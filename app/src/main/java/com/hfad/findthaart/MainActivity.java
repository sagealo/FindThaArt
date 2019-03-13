package com.hfad.findthaart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText title;
    private EditText keyWord;
    //private EditText type;
    //private EditText sizeOfSearch;

    private Button search;

    private Spinner typeSpinner;
    private Spinner sizeSpinner;

    private ArrayAdapter<CharSequence> adapterSize;
    private ArrayAdapter<CharSequence> adapterType;

    private static final String apiKey = "5454cff0-391d-11e9-8967-ed588d3c0fce";
    private String titleString;
    private String keyWordString;
    private String typeString;
    private int sizeInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        createSpinners();
        search.setOnClickListener(this);
        typeSpinner.setOnItemSelectedListener(this);
        sizeSpinner.setOnItemSelectedListener(this);


    }

    private void createSpinners() {
        adapterSize = ArrayAdapter.createFromResource(this,
                R.array.size_array,
                android.R.layout.simple_spinner_item);
        adapterType = ArrayAdapter.createFromResource(this,
                R.array.type_array,
                android.R.layout.simple_spinner_item);
        adapterSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapterSize);
        typeSpinner.setAdapter(adapterType);

    }

    private void wireWidgets() {
        title = findViewById(R.id.edittext_mainactivity_title);
        keyWord = findViewById(R.id.edittext_mainactivity_artist);
        //type = findViewById(R.id.edittext_mainactivity_type);
        //sizeOfSearch = findViewById(R.id.edittext_mainactivity_size);
        search = findViewById(R.id.button_mainactivity_search);
        typeSpinner = findViewById(R.id.spinner_mainactivity_type);
        sizeSpinner = findViewById(R.id.spinner_mainactivity_size);

    }

    private void searchArt(String type,
                           int size,
                           String keyWord,
                           String title,
                           String apiKey) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.harvardartmuseums.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HarvardArtService service =
                retrofit.create(HarvardArtService.class);

        Call<ArtResponse> artResponseCall =
                service.searchByResourceType(type, size, keyWord, title, apiKey);

        artResponseCall.enqueue(new Callback<ArtResponse>() {
            @Override
            public void onResponse(Call<ArtResponse> call, Response<ArtResponse> response) {
                //List<Record> records = response.body().getRecords();
                Log.d("ENQUEUE", "onResponse: " + response.toString());

                Intent i = new Intent(MainActivity.this, SearchResultActivity.class);
                i.putExtra("ArtResponse", response.body());
                startActivity(i);

            }


            @Override
            public void onFailure(Call<ArtResponse> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());

            }
        });
    }

    private void updateInfo() {
        titleString = title.getText().toString();
        keyWordString = keyWord.getText().toString();
        typeString = typeSpinner.getSelectedItem().toString();
        sizeInt = Integer.parseInt(sizeSpinner.getSelectedItem().toString());
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_mainactivity_search:
                updateInfo();

                searchArt(typeString, sizeInt, keyWordString, titleString, apiKey);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
       // super.onActivityResult(requestCode, resultCode, data);
       // if(requestCode== 1234 && resultCode == RESULT_OK){
         //TODO hold a list of all the past searches, ability to "star" favorites
        //}
    //}
}
