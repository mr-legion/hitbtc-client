package com.hitbtc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    @JsonProperty("base_currency")
    private String baseAsset;

    @JsonProperty("quote_currency")
    private String quoteAsset;

    private MarketStatus status;

    private MarketType type;

    /**
     * Whether margin trading is available.
     */
    private Boolean marginTrading;

    @JsonProperty("contract_type")
    private ContractType contractType;

    /**
     * Futures contract underlying asset.
     */
    private String underlying;

    /**
     * Futures expiration date. null for perpetual contracts.
     */
    private Date expiry;

    /**
     * Symbol quantity should be divided by this value with no remainder.
     */
    @JsonProperty("quantity_increment")
    private Double quantityIncrement;

    /**
     * Symbol price should be divided by this value with no remainder.
     */
    @JsonProperty("tick_size")
    private Double tickSize;

    /**
     * Default fee rate.
     */
    @JsonProperty("take_rate")
    private Double takeRate;

    /**
     * Default fee rate for market making trades.
     */
    @JsonProperty("make_rate")
    private Double makeRate;

    /**
     * Currency in which fees are determined.
     */
    @JsonProperty("fee_currency")
    private String feeCurrency;

    /**
     * Optional. Maximum leverage that the user can use for margin trading.
     * Shown only if margin_trading is true.
     */
    @JsonProperty("max_initial_leverage")
    private String maxInitialLeverage;

}
