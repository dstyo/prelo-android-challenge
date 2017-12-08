package com.dstyo.prelo.network.callback;

import com.dstyo.prelo.model.product.ProductResponse;
import com.dstyo.prelo.network.NetworkError;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public interface ProductCallback {
    void onSuccess(ProductResponse productResponse);
    void onError(NetworkError networkError);
}
