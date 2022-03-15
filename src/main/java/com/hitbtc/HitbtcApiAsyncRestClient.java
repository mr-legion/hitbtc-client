package com.hitbtc;

import com.hitbtc.domain.general.Asset;

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

}