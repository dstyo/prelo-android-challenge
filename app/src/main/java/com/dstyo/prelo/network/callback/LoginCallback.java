package com.dstyo.prelo.network.callback;

import com.dstyo.prelo.model.login.LoginResponse;
import com.dstyo.prelo.network.NetworkError;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public interface LoginCallback {
    void onSuccess(LoginResponse loginResponse);
    void onError(NetworkError networkError);
}
