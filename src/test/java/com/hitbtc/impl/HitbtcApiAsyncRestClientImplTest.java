package com.hitbtc.impl;

import com.hitbtc.HitbtcApiAsyncRestClient;
import com.hitbtc.HitbtcApiClientFactory;
import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HitbtcApiAsyncRestClientImplTest {

    private final HitbtcApiAsyncRestClient hitbtcApiAsyncRestClient =
            HitbtcApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Map<String, Asset> assets = hitbtcApiAsyncRestClient.getAssets().get();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        Map<String, MarketInfo> marketInfo = hitbtcApiAsyncRestClient.getMarketInfo().get();
        assertThat(marketInfo, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}