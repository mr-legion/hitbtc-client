package com.hitbtc.impl;

import com.hitbtc.HitbtcApiAsyncRestClient;
import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import com.hitbtc.domain.market.MarketTicker;
import com.hitbtc.domain.market.OrderBook;

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

    // Market endpoints

    @Override
    public CompletableFuture<Map<String, MarketInfo>> getMarketInfo() {
        CompletableFuture<Map<String, MarketInfo>> future = new CompletableFuture<>();
        hitbtcApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Map<String, MarketTicker>> getMarketTickers() {
        CompletableFuture<Map<String, MarketTicker>> future = new CompletableFuture<>();
        hitbtcApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Map<String, OrderBook>> getOrderBook(String symbols, Integer limit) {
        CompletableFuture<Map<String, OrderBook>> future = new CompletableFuture<>();
        hitbtcApiService.getOrderBook(symbols, limit).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
