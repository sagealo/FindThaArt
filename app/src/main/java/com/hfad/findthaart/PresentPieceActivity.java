package com.hfad.findthaart;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class PresentPieceActivity extends AppCompatActivity {
    private Record record;
    private TextView title;
    private TextView culture;
    private TextView department;

    private ImageView image;

    private TextView titleTitle;
    private TextView cultureTitle;
    private TextView departmentTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_piece);
        wireWidgets();
        populateActivity();
    }

    private void populateActivity() {
        record = getIntent().getParcelableExtra("FinalPiece");
        title.setText(record.getTitle().toString());
        culture.setText(record.getCulture().toString());
        department.setText(record.getDepartment().toString());
        image.setImageDrawable(Record.LoadImageFromWebOperations(record.getObjectId()));


    }

    private void wireWidgets() {
        title = findViewById(R.id.textview_presentpieceactivity_title);
        culture = findViewById(R.id.textview_presentpieceactivity_culture);
        department = findViewById(R.id.textview_presentpieceactivity_department);
        image = findViewById(R.id.imageview_presentpieceactivity_image);
        titleTitle = findViewById(R.id.textview_presentpieceactivity_titletitle);
        cultureTitle = findViewById(R.id.textview_presentpieceactivity_culturetitle);
        departmentTitle  = findViewById(R.id.textview_presentpieceactivity_departmenttitle);


    }


}
