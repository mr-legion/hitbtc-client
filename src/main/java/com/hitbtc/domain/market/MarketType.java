package com.hitbtc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketType {
    @JsonProperty("spot")
    SPOT,
    @JsonProperty("futures")
    FUTURES
}
