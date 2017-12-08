package com.dstyo.prelo.model.product;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class ProductResponse implements Parcelable {
    @SerializedName("_data")
    @Expose
    private List<Product> data = null;

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
    }

    public ProductResponse() {
    }

    protected ProductResponse(Parcel in) {
        this.data = in.createTypedArrayList(Product.CREATOR);
    }

    public static final Parcelable.Creator<ProductResponse> CREATOR = new Parcelable.Creator<ProductResponse>() {
        @Override
        public ProductResponse createFromParcel(Parcel source) {
            return new ProductResponse(source);
        }

        @Override
        public ProductResponse[] newArray(int size) {
            return new ProductResponse[size];
        }
    };
}
