package com.dstyo.prelo.activity.login;

import com.dstyo.prelo.base.BasePresenter;
import com.dstyo.prelo.model.body.User;
import com.dstyo.prelo.model.login.LoginResponse;
import com.dstyo.prelo.network.NetworkError;
import com.dstyo.prelo.network.api.ApiService;
import com.dstyo.prelo.network.callback.LoginCallback;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class LoginPresenter extends BasePresenter<LoginView, LoginViewModel> {

    private ApiService apiService;
    private CompositeSubscription subscriptions;

    public LoginPresenter(ApiService apiService) {
        this.apiService = apiService;
        this.subscriptions = new CompositeSubscription();
    }

    public void showLoading() {
        viewModel.setInProgress(true);
    }

    public void hideLoading() {
        viewModel.setInProgress(false);
    }

    public void userLogin(User user) {
        showLoading();
        final Subscription subscription = apiService.userLogin(user, new LoginCallback() {
            @Override
            public void onSuccess(LoginResponse loginResponse) {
                hideLoading();
                view.onSuccessLogin(loginResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                hideLoading();
                view.onErrorLogin(networkError.getAppErrorMessage());
            }
        });
        subscriptions.add(subscription);
    }

}
