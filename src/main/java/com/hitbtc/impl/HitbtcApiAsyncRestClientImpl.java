package com.hitbtc.impl;

import com.hitbtc.HitbtcApiAsyncRestClient;
import com.hitbtc.domain.general.Asset;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Hitbtc's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class HitbtcApiAsyncRestClientImpl implements HitbtcApiAsyncRestClient {

    private final HitbtcApiService hitbtcApiService;

    public HitbtcApiAsyncRestClientImpl(HitbtcApiService hitbtcApiService) {
        this.hitbtcApiService = hitbtcApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Map<String, Asset>> getAssets() {
        CompletableFuture<Map<String, Asset>> future = new CompletableFuture<>();
        hitbtcApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}