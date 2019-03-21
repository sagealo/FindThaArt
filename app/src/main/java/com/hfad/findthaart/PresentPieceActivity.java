package com.hfad.findthaart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PresentPieceActivity extends AppCompatActivity {
    private Record record;
    private TextView title;
    private TextView artistName;
    private TextView culture;
    private TextView department;

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
        // as of now, this is null artistName.setText(record.getArtist().toString());
        culture.setText(record.getCulture().toString());
        department.setText(record.getDepartment().toString());

    }

    private void wireWidgets() {
        title = findViewById(R.id.texteview_presentpieceactivity_title);
        artistName = findViewById(R.id.texteview_presentpieceactivity_artist);
        culture = findViewById(R.id.texteview_presentpieceactivity_culture);
        department = findViewById(R.id.texteview_presentpieceactivity_department);

    }
}
