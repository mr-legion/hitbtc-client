package com.hitbtc.impl;

import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import com.hitbtc.domain.market.MarketTicker;
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

    // Market endpoints

    @GET("/api/3/public/symbol")
    Call<Map<String, MarketInfo>> getMarketInfo();

    @GET("/api/3/public/ticker")
    Call<Map<String, MarketTicker>> getMarketTickers();

}
