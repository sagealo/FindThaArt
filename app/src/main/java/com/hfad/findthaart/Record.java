package com.hfad.findthaart;

import android.os.Parcel;
import android.os.Parcelable;

public class Record implements Parcelable {
    private int objectId;
    private String culture;
    private String department;
    private String title;
    private String primaryImageUrl;
    private String person;


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

    @Override
    public String toString() {
        return "Record{" +
                "objectId=" + objectId +
                ", culture='" + culture + '\'' +
                ", artistName='" + person + '\'' +
                ", department='" + department + '\'' +
                ", title='" + title + '\'' +
                ", primaryImageUrl=" + primaryImageUrl +
                '}';
    }

    protected Record(Parcel in) {
        objectId = in.readInt();
        culture = in.readString();
        department = in.readString();
        title = in.readString();
        primaryImageUrl = in.readString();
        person = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(objectId);
        dest.writeString(culture);
        dest.writeString(department);
        dest.writeString(title);
        dest.writeString(primaryImageUrl);
        dest.writeString(person);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Record> CREATOR = new Parcelable.Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };

    public String getArtist() {
        return person;
    }

    public void setArtist(String artist) {
        this.person = artist;
    }
}
