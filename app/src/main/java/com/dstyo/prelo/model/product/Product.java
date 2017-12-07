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
public class Product implements Parcelable {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("seller_id")
    @Expose
    private String sellerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("special_story")
    @Expose
    private String specialStory;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("price_original")
    @Expose
    private Integer priceOriginal;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("free_ongkir")
    @Expose
    private Integer freeOngkir;
    @SerializedName("num_lovelist")
    @Expose
    private Integer numLovelist;
    @SerializedName("num_comment")
    @Expose
    private Integer numComment;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("display_picts")
    @Expose
    private List<String> displayPicts = null;
    @SerializedName("update_time_uuid")
    @Expose
    private String updateTimeUuid;
    @SerializedName("update_time")
    @Expose
    private String updateTime;
    @SerializedName("proposed_brand")
    @Expose
    private String proposedBrand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getSpecialStory() {
        return specialStory;
    }

    public void setSpecialStory(String specialStory) {
        this.specialStory = specialStory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(Integer priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFreeOngkir() {
        return freeOngkir;
    }

    public void setFreeOngkir(Integer freeOngkir) {
        this.freeOngkir = freeOngkir;
    }

    public Integer getNumLovelist() {
        return numLovelist;
    }

    public void setNumLovelist(Integer numLovelist) {
        this.numLovelist = numLovelist;
    }

    public Integer getNumComment() {
        return numComment;
    }

    public void setNumComment(Integer numComment) {
        this.numComment = numComment;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public List<String> getDisplayPicts() {
        return displayPicts;
    }

    public void setDisplayPicts(List<String> displayPicts) {
        this.displayPicts = displayPicts;
    }

    public String getUpdateTimeUuid() {
        return updateTimeUuid;
    }

    public void setUpdateTimeUuid(String updateTimeUuid) {
        this.updateTimeUuid = updateTimeUuid;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getProposedBrand() {
        return proposedBrand;
    }

    public void setProposedBrand(String proposedBrand) {
        this.proposedBrand = proposedBrand;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.sellerId);
        dest.writeString(this.name);
        dest.writeString(this.categoryId);
        dest.writeString(this.brandId);
        dest.writeString(this.specialStory);
        dest.writeValue(this.price);
        dest.writeValue(this.priceOriginal);
        dest.writeValue(this.status);
        dest.writeValue(this.freeOngkir);
        dest.writeValue(this.numLovelist);
        dest.writeValue(this.numComment);
        dest.writeString(this.permalink);
        dest.writeStringList(this.displayPicts);
        dest.writeString(this.updateTimeUuid);
        dest.writeString(this.updateTime);
        dest.writeString(this.proposedBrand);
    }

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readString();
        this.sellerId = in.readString();
        this.name = in.readString();
        this.categoryId = in.readString();
        this.brandId = in.readString();
        this.specialStory = in.readString();
        this.price = (Integer) in.readValue(Integer.class.getClassLoader());
        this.priceOriginal = (Integer) in.readValue(Integer.class.getClassLoader());
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.freeOngkir = (Integer) in.readValue(Integer.class.getClassLoader());
        this.numLovelist = (Integer) in.readValue(Integer.class.getClassLoader());
        this.numComment = (Integer) in.readValue(Integer.class.getClassLoader());
        this.permalink = in.readString();
        this.displayPicts = in.createStringArrayList();
        this.updateTimeUuid = in.readString();
        this.updateTime = in.readString();
        this.proposedBrand = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
