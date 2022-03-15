package com.hitbtc;

import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import com.hitbtc.domain.market.MarketTicker;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * HitBTC API facade, supporting asynchronous/non-blocking access HitBTC's REST API.
 */
public interface HitbtcApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Map<String, Asset>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<Map<String, MarketInfo>> getMarketInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Map<String, MarketTicker>> getMarketTickers();

}