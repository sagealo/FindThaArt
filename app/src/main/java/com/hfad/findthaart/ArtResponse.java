package com.hfad.findthaart;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

class ArtResponse implements Parcelable {
    private int objectId;
    private String culture;
    private List<Record> records;
    private String department;
    private String title;
    private String primaryImageUrl;

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryImageUrl() {
        return primaryImageUrl;
    }

    public void setPrimaryImageUrl(String primaryImageUrl) {
        this.primaryImageUrl = primaryImageUrl;
    }



    protected ArtResponse(Parcel in) {
        objectId = in.readInt();
        culture = in.readString();
        if (in.readByte() == 0x01) {
            records = new ArrayList<Record>();
            in.readList(records, Record.class.getClassLoader());
        } else {
            records = null;
        }
        department = in.readString();
        title = in.readString();
        primaryImageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(objectId);
        dest.writeString(culture);
        if (records == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(records);
        }
        dest.writeString(department);
        dest.writeString(title);
        dest.writeString(primaryImageUrl);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ArtResponse> CREATOR = new Parcelable.Creator<ArtResponse>() {
        @Override
        public ArtResponse createFromParcel(Parcel in) {
            return new ArtResponse(in);
        }

        @Override
        public ArtResponse[] newArray(int size) {
            return new ArtResponse[size];
        }
    };
}