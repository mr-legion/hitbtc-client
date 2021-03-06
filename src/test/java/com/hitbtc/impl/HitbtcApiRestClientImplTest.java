package com.hitbtc.impl;

import com.hitbtc.HitbtcApiClientFactory;
import com.hitbtc.HitbtcApiRestClient;
import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import com.hitbtc.domain.market.MarketTicker;
import com.hitbtc.domain.market.OrderBook;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HitbtcApiRestClientImplTest {

    private final HitbtcApiRestClient hitbtcApiRestClient = HitbtcApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Map<String, Asset> assets = hitbtcApiRestClient.getAssets();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        Map<String, MarketInfo> marketInfo = hitbtcApiRestClient.getMarketInfo();
        assertThat(marketInfo, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Map<String, MarketTicker> marketTickers = hitbtcApiRestClient.getMarketTickers();
        assertThat(marketTickers, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSD() {
        String market = "BTCUSDT";
        int limit = 5;
        OrderBook orderBook = hitbtcApiRestClient.getOrderBook(market, limit).get(market);
        assertNotNull(orderBook);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }
}