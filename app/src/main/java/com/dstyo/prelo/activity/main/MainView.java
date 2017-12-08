package com.dstyo.prelo.activity.main;

import com.dstyo.prelo.model.product.ProductResponse;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
interface MainView {

    void shoProgressLoading();

    void hideProgressLoading();

    void fetchDataProduct(String token);

    void onSuccessFetchProduct(ProductResponse productResponse);

    void onErrorFetchProduct(String error);

}
