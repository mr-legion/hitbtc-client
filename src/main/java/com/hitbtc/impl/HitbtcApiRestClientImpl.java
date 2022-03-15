package com.hitbtc.impl;

import com.hitbtc.HitbtcApiRestClient;
import com.hitbtc.domain.general.Asset;

import java.util.Map;

import static com.hitbtc.impl.HitbtcApiServiceGenerator.executeSync;

/**
 * Implementation of Hitbtc's REST API using Retrofit with synchronous/blocking method calls.
 */
public class HitbtcApiRestClientImpl implements HitbtcApiRestClient {

    private final HitbtcApiService hitbtcApiService;

    public HitbtcApiRestClientImpl(HitbtcApiService hitbtcApiService) {
        this.hitbtcApiService = hitbtcApiService;
    }

    // General endpoints

    @Override
    public Map<String, Asset> getAssets() {
        return executeSync(hitbtcApiService.getAssets());
    }
}
