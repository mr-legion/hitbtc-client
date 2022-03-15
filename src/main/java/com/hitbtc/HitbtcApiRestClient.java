package com.hitbtc;

import com.hitbtc.domain.general.Asset;
import com.hitbtc.domain.market.MarketInfo;
import com.hitbtc.domain.market.MarketTicker;
import com.hitbtc.domain.market.OrderBook;

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

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    Map<String, MarketInfo> getMarketInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    Map<String, MarketTicker> getMarketTickers();

    /**
     * Get orderbook for the market.
     *
     * @param symbols comma-separated list of symbol codes
     * @param limit   depth of the order book
     * @return orderbook
     */
    Map<String, OrderBook> getOrderBook(String symbols, Integer limit);

}