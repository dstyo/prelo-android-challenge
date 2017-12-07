package com.dstyo.prelo.activity.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class LoginViewModel extends BaseObservable {

    public boolean isInProgress = false;

    @Bindable
    public boolean isInProgress() {
        return isInProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.isInProgress = inProgress;
        notifyPropertyChanged(BR.inProgress);
    }
}
