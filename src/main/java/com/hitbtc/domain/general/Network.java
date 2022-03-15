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
    private boolean main;

    @JsonProperty("payin_enabled")
    private boolean depositEnabled;

    @JsonProperty("payout_enabled")
    private boolean withdrawEnabled;

    @JsonProperty("payin_confirmations")
    private int minConfirm;

    @JsonProperty("payout_fee")
    private double withdrawFee;

    @JsonProperty("payin_payment_id")
    private boolean payinPaymentId;

    @JsonProperty("payout_is_payment_id")
    private boolean payoutPaymentId;

    @JsonProperty("precision_payout")
    private double precisionPayout;

}
