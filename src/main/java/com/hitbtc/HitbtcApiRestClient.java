package com.hitbtc;

import com.hitbtc.domain.general.Asset;

import java.util.Map;

/**
 * HitBTC API facade, supporting synchronous/blocking access HitBTC's REST API.
 */
public interface HitbtcApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Map<String, Asset> getAssets();

}