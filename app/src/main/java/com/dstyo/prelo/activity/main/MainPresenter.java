package com.dstyo.prelo.activity.main;

import com.dstyo.prelo.base.BasePresenter;
import com.dstyo.prelo.model.product.ProductResponse;
import com.dstyo.prelo.network.NetworkError;
import com.dstyo.prelo.network.api.ApiService;
import com.dstyo.prelo.network.callback.ProductCallback;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class MainPresenter extends BasePresenter<MainView, MainViewModel> {

    private ApiService apiService;
    private CompositeSubscription subscriptions;

    public MainPresenter(ApiService apiService) {
        this.apiService = apiService;
        subscriptions = new CompositeSubscription();
    }

    public void showLoading() {
        viewModel.setInProgress(true);
    }

    public void hideLoading() {
        viewModel.setInProgress(false);
    }

    public void getProductList(String token) {
        showLoading();
        final Subscription subscription = apiService.getProductList(token, new ProductCallback() {
            @Override
            public void onSuccess(ProductResponse productResponse) {
                hideLoading();
                view.onSuccessFetchProduct(productResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                hideLoading();
                view.onErrorFetchProduct(networkError.getAppErrorMessage());
            }
        });
        subscriptions.add(subscription);
    }

    public void reloadProducList(String token) {

        if (subscriptions.hasSubscriptions()) {
            subscriptions.clear();
        }

        view.fetchDataProduct(token);
    }

}
