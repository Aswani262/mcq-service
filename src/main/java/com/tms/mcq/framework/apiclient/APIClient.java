package com.tms.mcq.framework.apiclient;

import java.util.Map;

public interface APIClient<R, D> {

    public R post(String url, D data, Map<String, Object> headers, int timeout);

    public R get(String url, D data, Map<String, Object> headers, int timeout);
//    public Mono<R> post(String url, D data, Map<String,Object> headers);
//    public Mono<R> get(String url, D data, Map<String,Object> headers);
//
//    public Flux<R> get(String url, D data, Map<String,Object> headers);
//    public Flux<R> post(String url, D data, Map<String,Object> headers);
}
