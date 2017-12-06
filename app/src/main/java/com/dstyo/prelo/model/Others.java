package com.dstyo.prelo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class Others implements Parcelable {
    @SerializedName("register_time")
    @Expose
    private String registerTime;
    @SerializedName("platform_register_from")
    @Expose
    private String platformRegisterFrom;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("register_by_fb")
    @Expose
    private boolean registerByFb;
    @SerializedName("register_by_path")
    @Expose
    private boolean registerByPath;
    @SerializedName("register_by_twitter")
    @Expose
    private boolean registerByTwitter;
    @SerializedName("register_by_google")
    @Expose
    private boolean registerByGoogle;
    @SerializedName("last_seen")
    @Expose
    private String lastSeen;
    @SerializedName("last_sent_sms")
    @Expose
    private String lastSentSms;
    @SerializedName("is_phone_verified")
    @Expose
    private boolean isPhoneVerified;
    @SerializedName("phone_code")
    @Expose
    private String phoneCode;
    @SerializedName("total_sent_sms")
    @Expose
    private int totalSentSms;
    @SerializedName("device_registration_id")
    @Expose
    private String deviceRegistrationId;
    @SerializedName("device_type")
    @Expose
    private String deviceType;
    @SerializedName("email_code")
    @Expose
    private String emailCode;
    @SerializedName("is_email_verified")
    @Expose
    private boolean isEmailVerified;
    @SerializedName("num_reviewer")
    @Expose
    private int numReviewer;
    @SerializedName("total_star")
    @Expose
    private int totalStar;
    @SerializedName("max_push_in_period")
    @Expose
    private int maxPushInPeriod;
    @SerializedName("push_product_period")
    @Expose
    private int pushProductPeriod;
    @SerializedName("category_preferences_ids")
    @Expose
    private List<String> categoryPreferencesIds = null;
    @SerializedName("fa_id")
    @Expose
    private List<String> faId = null;
    @SerializedName("ga_id")
    @Expose
    private List<String> gaId = null;

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getPlatformRegisterFrom() {
        return platformRegisterFrom;
    }

    public void setPlatformRegisterFrom(String platformRegisterFrom) {
        this.platformRegisterFrom = platformRegisterFrom;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isRegisterByFb() {
        return registerByFb;
    }

    public void setRegisterByFb(boolean registerByFb) {
        this.registerByFb = registerByFb;
    }

    public boolean isRegisterByPath() {
        return registerByPath;
    }

    public void setRegisterByPath(boolean registerByPath) {
        this.registerByPath = registerByPath;
    }

    public boolean isRegisterByTwitter() {
        return registerByTwitter;
    }

    public void setRegisterByTwitter(boolean registerByTwitter) {
        this.registerByTwitter = registerByTwitter;
    }

    public boolean isRegisterByGoogle() {
        return registerByGoogle;
    }

    public void setRegisterByGoogle(boolean registerByGoogle) {
        this.registerByGoogle = registerByGoogle;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLastSentSms() {
        return lastSentSms;
    }

    public void setLastSentSms(String lastSentSms) {
        this.lastSentSms = lastSentSms;
    }

    public boolean isPhoneVerified() {
        return isPhoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        isPhoneVerified = phoneVerified;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public int getTotalSentSms() {
        return totalSentSms;
    }

    public void setTotalSentSms(int totalSentSms) {
        this.totalSentSms = totalSentSms;
    }

    public String getDeviceRegistrationId() {
        return deviceRegistrationId;
    }

    public void setDeviceRegistrationId(String deviceRegistrationId) {
        this.deviceRegistrationId = deviceRegistrationId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public int getNumReviewer() {
        return numReviewer;
    }

    public void setNumReviewer(int numReviewer) {
        this.numReviewer = numReviewer;
    }

    public int getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(int totalStar) {
        this.totalStar = totalStar;
    }

    public int getMaxPushInPeriod() {
        return maxPushInPeriod;
    }

    public void setMaxPushInPeriod(int maxPushInPeriod) {
        this.maxPushInPeriod = maxPushInPeriod;
    }

    public int getPushProductPeriod() {
        return pushProductPeriod;
    }

    public void setPushProductPeriod(int pushProductPeriod) {
        this.pushProductPeriod = pushProductPeriod;
    }

    public List<String> getCategoryPreferencesIds() {
        return categoryPreferencesIds;
    }

    public void setCategoryPreferencesIds(List<String> categoryPreferencesIds) {
        this.categoryPreferencesIds = categoryPreferencesIds;
    }

    public List<String> getFaId() {
        return faId;
    }

    public void setFaId(List<String> faId) {
        this.faId = faId;
    }

    public List<String> getGaId() {
        return gaId;
    }

    public void setGaId(List<String> gaId) {
        this.gaId = gaId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.registerTime);
        dest.writeString(this.platformRegisterFrom);
        dest.writeString(this.lastLogin);
        dest.writeByte(this.registerByFb ? (byte) 1 : (byte) 0);
        dest.writeByte(this.registerByPath ? (byte) 1 : (byte) 0);
        dest.writeByte(this.registerByTwitter ? (byte) 1 : (byte) 0);
        dest.writeByte(this.registerByGoogle ? (byte) 1 : (byte) 0);
        dest.writeString(this.lastSeen);
        dest.writeString(this.lastSentSms);
        dest.writeByte(this.isPhoneVerified ? (byte) 1 : (byte) 0);
        dest.writeString(this.phoneCode);
        dest.writeInt(this.totalSentSms);
        dest.writeString(this.deviceRegistrationId);
        dest.writeString(this.deviceType);
        dest.writeString(this.emailCode);
        dest.writeByte(this.isEmailVerified ? (byte) 1 : (byte) 0);
        dest.writeInt(this.numReviewer);
        dest.writeInt(this.totalStar);
        dest.writeInt(this.maxPushInPeriod);
        dest.writeInt(this.pushProductPeriod);
        dest.writeStringList(this.categoryPreferencesIds);
        dest.writeStringList(this.faId);
        dest.writeStringList(this.gaId);
    }

    public Others() {
    }

    protected Others(Parcel in) {
        this.registerTime = in.readString();
        this.platformRegisterFrom = in.readString();
        this.lastLogin = in.readString();
        this.registerByFb = in.readByte() != 0;
        this.registerByPath = in.readByte() != 0;
        this.registerByTwitter = in.readByte() != 0;
        this.registerByGoogle = in.readByte() != 0;
        this.lastSeen = in.readString();
        this.lastSentSms = in.readString();
        this.isPhoneVerified = in.readByte() != 0;
        this.phoneCode = in.readString();
        this.totalSentSms = in.readInt();
        this.deviceRegistrationId = in.readString();
        this.deviceType = in.readString();
        this.emailCode = in.readString();
        this.isEmailVerified = in.readByte() != 0;
        this.numReviewer = in.readInt();
        this.totalStar = in.readInt();
        this.maxPushInPeriod = in.readInt();
        this.pushProductPeriod = in.readInt();
        this.categoryPreferencesIds = in.createStringArrayList();
        this.faId = in.createStringArrayList();
        this.gaId = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Others> CREATOR = new Parcelable.Creator<Others>() {
        @Override
        public Others createFromParcel(Parcel source) {
            return new Others(source);
        }

        @Override
        public Others[] newArray(int size) {
            return new Others[size];
        }
    };
}
