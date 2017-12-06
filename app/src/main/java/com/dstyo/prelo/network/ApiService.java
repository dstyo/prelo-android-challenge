package com.dstyo.prelo.network;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }
}
