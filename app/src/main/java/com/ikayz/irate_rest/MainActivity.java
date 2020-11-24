package com.ikayz.irate_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    AwesomeValidation awesomeValidation;

    EditText restaurantName;
    EditText dateTime;
    EditText mealPrice;
    RatingBar serviceRating;
    RatingBar cleanlinessRating;
    RatingBar foodQualityRating;
    EditText reporterName;
    DatePicker timeDate;
    EditText notes;

    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantName  = (EditText) findViewById(R.id.restaurant_name);
        dateTime = (EditText) findViewById(R.id.date_time);
        mealPrice = (EditText) findViewById(R.id.price);
        serviceRating = (RatingBar) findViewById(R.id.rating_bar_service);
        cleanlinessRating = (RatingBar) findViewById(R.id.rating_bar_cleanliness);
        foodQualityRating = (RatingBar) findViewById(R.id.rating_bar);
        reporterName = (EditText) findViewById(R.id.edit_reporter);
        timeDate = findViewById(R.id.DatePickerDOB);
        notes = findViewById(R.id.tv_notes_);

        Spinner spinner = findViewById(R.id.restaurant_spinner);
        Button submitReview = findViewById(R.id.btn_submit);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.restaurant_spinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Init Validation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Field validations
        awesomeValidation.addValidation(this, R.id.restaurant_name,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.date_time,
                RegexTemplate.NOT_EMPTY, R.string.invalid_date);
        awesomeValidation.addValidation(this, R.id.price,
                RegexTemplate.NOT_EMPTY, R.string.invalid_price);
        awesomeValidation.addValidation(this, R.id.rating_bar_service,
                Range.closed(1, 5), R.string.invalid_rating_service);
        awesomeValidation.addValidation(this, R.id.rating_bar_cleanliness,
                Range.closed(1, 5), R.string.invalid_rating_cleanliness);
        awesomeValidation.addValidation(this, R.id.rating_bar,
                Range.closed(1, 5), R.string.invalid_rating_food);
        awesomeValidation.addValidation(this, R.id.edit_reporter,
                RegexTemplate.NOT_EMPTY, R.string.invalid_reporter_name);
//
//        RestaurantHelperClass helperClass = new RestaurantHelperClass(restaurant, date, price, reporter);

        submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
////                    float service = serviceRating.getRating();
////                    float cleanliness = cleanlinessRating.getRating();
////                    float food = foodQualityRating.getRating();



                mDatabase = FirebaseDatabase.getInstance();
                mDatabaseReference = mDatabase.getReference("restaurants");
                if(awesomeValidation.validate()) {
                    // Get All the
                    String restaurant = restaurantName.getText().toString();
                    String date = dateTime.getText().toString();
                    String price = mealPrice.getText().toString();
                    String reporter = reporterName.getText().toString();
                    Float service = serviceRating.getRating();
                    Float cleanliness = cleanlinessRating.getRating();
                    Float food = foodQualityRating.getRating();
                    int time = timeDate.getYear();
                    String note = notes.getText().toString();

                    RestaurantHelperClass helperClass = new RestaurantHelperClass(
                            restaurant, date, price, reporter, service, cleanliness, food, time, note);
                    mDatabaseReference.setValue(helperClass);
                    Toast.makeText(MainActivity.this, "Rating submitted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Validation failed check fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}