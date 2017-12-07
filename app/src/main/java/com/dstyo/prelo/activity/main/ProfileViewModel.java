package com.dstyo.prelo.activity.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dstyo.prelo.model.login.LoginData;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.08.12
 */
public class ProfileViewModel extends BaseObservable {

    private LoginData loginData;

    public ProfileViewModel(LoginData loginData) {
        this.loginData = loginData;
        notifyProperties();
    }

    private void notifyProperties() {
        notifyPropertyChanged(BR.profileName);
        notifyPropertyChanged(BR.profileEmail);
        notifyPropertyChanged(BR.profileDescription);
        notifyPropertyChanged(BR.profileImageURL);
    }

    @Bindable
    public String getProfileName() {
        return loginData.getFullname();
    }

    @Bindable
    public String getProfileEmail() {
        return loginData.getEmail();
    }

    @Bindable
    public String getProfileDescription() {
        return loginData.getDefaultAddress().getProvinceName() + " , " +
                loginData.getDefaultAddress().getRegionName() + " , " +
                loginData.getDefaultAddress().getSubdistrictName();
    }

    @Bindable
    public String getProfileImageURL() {
        return loginData.getProfile().getPict();
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(imageView);
    }
}
