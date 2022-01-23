package com.tms.framework.apiclient;

import java.util.Map;


public class GenericAPIClient<R, D> implements APIClient<R, D> {


//    WebClient webClient;
//
//    public GenericAPIClient(){
//        //WebClient.builder().
//    }


    @Override
    public R post(String url, D data, Map<String, Object> headers, int timeout) {
        return null;
    }

    @Override
    public R get(String url, D data, Map<String, Object> headers, int timeout) {
        return null;
    }
}
