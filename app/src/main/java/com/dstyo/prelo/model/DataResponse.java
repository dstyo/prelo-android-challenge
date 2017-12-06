package com.dstyo.prelo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class DataResponse implements Parcelable {
    @SerializedName("_data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public DataResponse() {
    }

    protected DataResponse(Parcel in) {
        this.data = in.readParcelable(Data.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataResponse> CREATOR = new Parcelable.Creator<DataResponse>() {
        @Override
        public DataResponse createFromParcel(Parcel source) {
            return new DataResponse(source);
        }

        @Override
        public DataResponse[] newArray(int size) {
            return new DataResponse[size];
        }
    };
}
