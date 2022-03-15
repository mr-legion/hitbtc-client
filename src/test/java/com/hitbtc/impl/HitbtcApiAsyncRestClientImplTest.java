package com.hitbtc.impl;

import com.hitbtc.HitbtcApiAsyncRestClient;
import com.hitbtc.HitbtcApiClientFactory;
import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import com.hitbtc.domain.market.MarketTicker;
import com.hitbtc.domain.market.OrderBook;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        Map<String, MarketTicker> marketTickers = hitbtcApiAsyncRestClient.getMarketTickers().get();
        assertThat(marketTickers, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSD() throws ExecutionException, InterruptedException {
        String market = "BTCUSDT";
        int limit = 5;
        OrderBook orderBook = hitbtcApiAsyncRestClient.getOrderBook(market, limit).get().get(market);
        assertNotNull(orderBook);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }
}