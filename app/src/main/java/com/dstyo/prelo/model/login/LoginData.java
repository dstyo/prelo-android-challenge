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

public class LoginData implements Parcelable {

    @SerializedName("shipping_preferences_ids")
    @Expose
    private List<String> shippingPreferencesIds = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("others")
    @Expose
    private Others others;
    @SerializedName("main_bank_account")
    @Expose
    private MainBankAccount mainBankAccount;
    @SerializedName("rent")
    @Expose
    private Rent rent;
    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("default_address")
    @Expose
    private DefaultAddress defaultAddress;
    @SerializedName("token")
    @Expose
    private String token;

    public List<String> getShippingPreferencesIds() {
        return shippingPreferencesIds;
    }

    public void setShippingPreferencesIds(List<String> shippingPreferencesIds) {
        this.shippingPreferencesIds = shippingPreferencesIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Others getOthers() {
        return others;
    }

    public void setOthers(Others others) {
        this.others = others;
    }

    public MainBankAccount getMainBankAccount() {
        return mainBankAccount;
    }

    public void setMainBankAccount(MainBankAccount mainBankAccount) {
        this.mainBankAccount = mainBankAccount;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public DefaultAddress getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(DefaultAddress defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.shippingPreferencesIds);
        dest.writeString(this.id);
        dest.writeParcelable(this.profile, flags);
        dest.writeString(this.username);
        dest.writeString(this.email);
        dest.writeString(this.fullname);
        dest.writeParcelable(this.others, flags);
        dest.writeParcelable(this.mainBankAccount, flags);
        dest.writeParcelable(this.rent, flags);
        dest.writeParcelable(this.shop, flags);
        dest.writeParcelable(this.defaultAddress, flags);
        dest.writeString(this.token);
    }

    public LoginData() {
    }

    protected LoginData(Parcel in) {
        this.shippingPreferencesIds = in.createStringArrayList();
        this.id = in.readString();
        this.profile = in.readParcelable(Profile.class.getClassLoader());
        this.username = in.readString();
        this.email = in.readString();
        this.fullname = in.readString();
        this.others = in.readParcelable(Others.class.getClassLoader());
        this.mainBankAccount = in.readParcelable(MainBankAccount.class.getClassLoader());
        this.rent = in.readParcelable(Rent.class.getClassLoader());
        this.shop = in.readParcelable(Shop.class.getClassLoader());
        this.defaultAddress = in.readParcelable(DefaultAddress.class.getClassLoader());
        this.token = in.readString();
    }

    public static final Parcelable.Creator<LoginData> CREATOR = new Parcelable.Creator<LoginData>() {
        @Override
        public LoginData createFromParcel(Parcel source) {
            return new LoginData(source);
        }

        @Override
        public LoginData[] newArray(int size) {
            return new LoginData[size];
        }
    };
}
