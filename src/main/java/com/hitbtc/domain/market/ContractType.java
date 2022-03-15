package com.hitbtc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ContractType {
    @JsonProperty("perpetual")
    PERPETUAL,
    @JsonProperty("cash_settled")
    CASH_SETTLED
}
