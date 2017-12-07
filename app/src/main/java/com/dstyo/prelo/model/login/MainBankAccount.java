package com.dstyo.prelo.model.login;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class MainBankAccount implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public MainBankAccount() {
    }

    protected MainBankAccount(Parcel in) {
    }

    public static final Parcelable.Creator<MainBankAccount> CREATOR = new Parcelable.Creator<MainBankAccount>() {
        @Override
        public MainBankAccount createFromParcel(Parcel source) {
            return new MainBankAccount(source);
        }

        @Override
        public MainBankAccount[] newArray(int size) {
            return new MainBankAccount[size];
        }
    };
}
