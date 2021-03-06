package com.dstyo.prelo.network.api;

import com.dstyo.prelo.model.body.User;
import com.dstyo.prelo.model.login.LoginResponse;
import com.dstyo.prelo.model.product.ProductResponse;
import com.dstyo.prelo.network.NetworkError;
import com.dstyo.prelo.network.callback.LoginCallback;
import com.dstyo.prelo.network.callback.ProductCallback;
import com.dstyo.prelo.util.Const;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Subscription userLogin(User user, final LoginCallback callback) {
        return restClient.userLogin(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends LoginResponse>>() {
                    @Override
                    public Observable<? extends LoginResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(LoginResponse dataResponse) {
                        callback.onSuccess(dataResponse);
                    }
                });
    }

    public Subscription getProductList(String token, final ProductCallback callback) {
        token = Const.TOKEN + " " + token;
        return restClient.getProductList(token)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ProductResponse>>() {
                    @Override
                    public Observable<? extends ProductResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ProductResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(ProductResponse dataResponse) {
                        callback.onSuccess(dataResponse);
                    }
                });
    }


}
