package com.dstyo.prelo.network.api;

import com.dstyo.prelo.model.body.User;
import com.dstyo.prelo.model.login.LoginResponse;
import com.dstyo.prelo.model.product.ProductResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public interface RestClient {

    @POST("auth/login")
    Observable<LoginResponse> userLogin(@Body User user);

    @GET("me/lovelist")
    Observable<ProductResponse> getProductList(@Header("Authorization") String authorization);
}
