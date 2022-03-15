package com.hitbtc.impl;

import com.hitbtc.domain.general.Asset;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

/**
 * HitBTC's REST API URL mappings.
 */
public interface HitbtcApiService {

    // General endpoints

    @GET("/api/3/public/currency")
    Call<Map<String, Asset>> getAssets();

}
