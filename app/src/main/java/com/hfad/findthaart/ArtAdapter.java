package com.hfad.findthaart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArtAdapter extends ArrayAdapter<Record>{
    private Context context;
    private int resource;
    private List<Record> recordList;
    public ArtAdapter(@NonNull Context context, int resource, @NonNull List<Record> recordList) {
        super(context, resource, recordList);
        this.context = context;
        this.resource = resource;
        this.recordList = recordList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        //just like we did with fragments
        //inflate a layout, wire widgets, insert data, return the layout
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recordlist,
                    parent, false);
        }
        TextView textViewTitle =
                convertView.findViewById(R.id.textview_recorditem_title);
        TextView textViewArtistName =
                convertView.findViewById(R.id.textview_recorditem_artistname);

        Record currentRecord = recordList.get(position);
        textViewTitle.setText(currentRecord.getTitle());
        textViewArtistName.setText(currentRecord.getDepartment());

        return convertView;
    }

}
