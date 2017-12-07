package com.dstyo.prelo.model.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class Rent implements Parcelable {
    @SerializedName("docs")
    @Expose
    private List<String> docs = null;

    public List<String> getDocs() {
        return docs;
    }

    public void setDocs(List<String> docs) {
        this.docs = docs;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.docs);
    }

    public Rent() {
    }

    protected Rent(Parcel in) {
        this.docs = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Rent> CREATOR = new Parcelable.Creator<Rent>() {
        @Override
        public Rent createFromParcel(Parcel source) {
            return new Rent(source);
        }

        @Override
        public Rent[] newArray(int size) {
            return new Rent[size];
        }
    };
}
