package com.dstyo.prelo.activity.login;

import com.dstyo.prelo.model.login.LoginResponse;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public interface LoginView {

    void showProgressLoading();

    void hideProgressLoading();

    void onSuccessLogin(LoginResponse response);

    void onErrorLogin(String error);
}
