package com.hfad.findthaart;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArtResponse response;
    private ListView searchResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        wireWidgets();
        searchResultList.setOnItemClickListener(this);
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




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int index = searchResultList.indexOfChild(view);
        //Toast.makeText(SearchResultActivity.this, "index " + index, Toast.LENGTH_SHORT).show();
        Record r = (Record) searchResultList.getAdapter().getItem(index);
        Intent i = new Intent(SearchResultActivity.this, PresentPieceActivity.class);
        i.putExtra("FinalPiece", r);
        startActivity(i);

    }

}
