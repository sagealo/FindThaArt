package com.hfad.findthaart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {

    private ArtResponse response;
    private ListView searchResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        wireWidgets();

        populateListView();

    }

    private void populateListView() {
        response = getIntent().getParcelableExtra("ArtResponse");
        ArtAdapter adapter = new ArtAdapter(SearchResultActivity.this,
                    R.layout.item_recordlist,
                    response.getRecords());
        searchResultList.setAdapter(adapter);


    }

    private void updateInfo() {
        //searchResultString.setText();

    }

    private void wireWidgets() {
        searchResultList = findViewById(R.id.listview_searchresultactivity_searchresults);
    }
}
