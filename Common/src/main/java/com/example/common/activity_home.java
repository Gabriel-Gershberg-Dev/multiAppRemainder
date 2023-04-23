package com.example.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.TimeZone;

public class activity_home extends AppCompatActivity {
    private Button addRmd;
    private DatePicker datePicker;
    private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViews();
        addRmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRmd("hiii");
            }
        });
    }

    private void addRmd(String title ) {
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), timePicker.getHour(), timePicker.getMinute());
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, title);
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, beginTime.getTimeInMillis() + (60 * 60 * 1000)); // set end time 1 hour after start time
        intent.putExtra(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
        startActivity(intent);
    }

    private void findViews() {
        addRmd=findViewById(R.id.common_BTN_addRMD);
        datePicker=findViewById(R.id.datePicker_Common);
        timePicker=findViewById(R.id.timePicker_Common);
    }
}