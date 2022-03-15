package com.hitbtc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    @JsonProperty("working")
    WORKING,
    @JsonProperty("suspended")
    SUSPENDED,
    @JsonProperty("clearing")
    CLEARING
}
