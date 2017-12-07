package com.dstyo.prelo.activity.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.dstyo.prelo.BaseApplication;
import com.dstyo.prelo.R;
import com.dstyo.prelo.activity.main.MainActivity;
import com.dstyo.prelo.base.BaseActivity;
import com.dstyo.prelo.databinding.ActivityLoginBinding;
import com.dstyo.prelo.helper.InputHelper;
import com.dstyo.prelo.model.body.User;
import com.dstyo.prelo.model.login.LoginResponse;
import com.dstyo.prelo.network.api.ApiService;
import com.dstyo.prelo.util.Const;

import javax.inject.Inject;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.06.12
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel, LoginPresenter>
        implements LoginView {

    @Inject
    public ApiService apiService;

    @Override
    protected void initInjection() {
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    @Override
    protected void initViewModel() {
        viewModel = new LoginViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initPresenter() {
        presenter = new LoginPresenter(apiService);
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        init();
        binding.btnLogin.setOnClickListener(onClickListener());
    }

    private View.OnClickListener onClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputHelper.hideKeyboard(LoginActivity.this);
                User user = new User();
                user.setUsername(binding.inputEmail.getText().toString());
                user.setPassword(binding.inputPassword.getText().toString());
                presenter.userLogin(user);
            }
        };
    }

    private void init() {
        LoginHandler handler = new LoginHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
    }

    @Override
    public void showProgressLoading() {
        presenter.showLoading();
    }

    @Override
    public void hideProgressLoading() {
        presenter.hideLoading();
    }

    @Override
    public void onSuccessLogin(LoginResponse response) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Const.USER, response.getData());
        startActivity(intent);
    }

    @Override
    public void onErrorLogin(String error) {
        Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
