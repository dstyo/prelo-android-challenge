package com.dstyo.prelo.model.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class DefaultAddress implements Parcelable {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;
    @SerializedName("create_time")
    @Expose
    private String createTime;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("subdistrict_name")
    @Expose
    private String subdistrictName;
    @SerializedName("subdistrict_id")
    @Expose
    private String subdistrictId;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("region_id")
    @Expose
    private String regionId;
    @SerializedName("province_name")
    @Expose
    private String provinceName;
    @SerializedName("province_id")
    @Expose
    private String provinceId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("owner_name")
    @Expose
    private String ownerName;
    @SerializedName("address_name")
    @Expose
    private String addressName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public String getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(String subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeByte(this.isDefault ? (byte) 1 : (byte) 0);
        dest.writeString(this.createTime);
        dest.writeString(this.postalCode);
        dest.writeString(this.address);
        dest.writeString(this.subdistrictName);
        dest.writeString(this.subdistrictId);
        dest.writeString(this.regionName);
        dest.writeString(this.regionId);
        dest.writeString(this.provinceName);
        dest.writeString(this.provinceId);
        dest.writeString(this.phone);
        dest.writeString(this.ownerName);
        dest.writeString(this.addressName);
    }

    public DefaultAddress() {
    }

    protected DefaultAddress(Parcel in) {
        this.id = in.readString();
        this.isDefault = in.readByte() != 0;
        this.createTime = in.readString();
        this.postalCode = in.readString();
        this.address = in.readString();
        this.subdistrictName = in.readString();
        this.subdistrictId = in.readString();
        this.regionName = in.readString();
        this.regionId = in.readString();
        this.provinceName = in.readString();
        this.provinceId = in.readString();
        this.phone = in.readString();
        this.ownerName = in.readString();
        this.addressName = in.readString();
    }

    public static final Parcelable.Creator<DefaultAddress> CREATOR = new Parcelable.Creator<DefaultAddress>() {
        @Override
        public DefaultAddress createFromParcel(Parcel source) {
            return new DefaultAddress(source);
        }

        @Override
        public DefaultAddress[] newArray(int size) {
            return new DefaultAddress[size];
        }
    };
}
