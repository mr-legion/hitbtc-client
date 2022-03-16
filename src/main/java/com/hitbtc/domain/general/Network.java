package com.hitbtc.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Network information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

    @JsonProperty("network")
    private String name;

    private String protocol;

    /**
     * If default network.
     */
    private Boolean main;

    @JsonProperty("payin_enabled")
    private Boolean depositEnabled;

    @JsonProperty("payout_enabled")
    private Boolean withdrawEnabled;

    @JsonProperty("payin_confirmations")
    private Integer minConfirm;

    @JsonProperty("payout_fee")
    private Double withdrawFee;

    @JsonProperty("payin_payment_id")
    private Boolean payinPaymentId;

    @JsonProperty("payout_is_payment_id")
    private Boolean payoutPaymentId;

    @JsonProperty("precision_payout")
    private Double precisionPayout;

}
