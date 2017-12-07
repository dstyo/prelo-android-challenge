package com.dstyo.prelo.model.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class Profile implements Parcelable {
    @SerializedName("pict")
    @Expose
    private String pict;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("province_id")
    @Expose
    private String provinceId;
    @SerializedName("region_id")
    @Expose
    private String regionId;
    @SerializedName("subdistrict_id")
    @Expose
    private String subdistrictId;
    @SerializedName("subdistrict_name")
    @Expose
    private String subdistrictName;

    public String getPict() {
        return pict;
    }

    public void setPict(String pict) {
        this.pict = pict;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(String subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pict);
        dest.writeString(this.gender);
        dest.writeString(this.phone);
        dest.writeString(this.provinceId);
        dest.writeString(this.regionId);
        dest.writeString(this.subdistrictId);
        dest.writeString(this.subdistrictName);
    }

    public Profile() {
    }

    protected Profile(Parcel in) {
        this.pict = in.readString();
        this.gender = in.readString();
        this.phone = in.readString();
        this.provinceId = in.readString();
        this.regionId = in.readString();
        this.subdistrictId = in.readString();
        this.subdistrictName = in.readString();
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
