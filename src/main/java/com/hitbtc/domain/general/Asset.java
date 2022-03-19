package com.hitbtc.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * An asset.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("full_name")
    private String name;

    @JsonProperty("payin_enabled")
    private Boolean depositEnabled;

    @JsonProperty("payout_enabled")
    private Boolean withdrawEnabled;

    @JsonProperty("transfer_enabled")
    private Boolean transferEnabled;

    @JsonProperty("precision_transfer")
    private Double precisionTransfer;

    private List<Network> networks;

    public boolean isDepositEnabled() {
        return networks.stream().anyMatch(Network::getDepositEnabled);
    }

    public boolean isWithdrawEnabled() {
        return networks.stream().anyMatch(Network::getWithdrawEnabled);
    }

    public Integer getMinConfirm() {

        Integer minConfirm = null;

        for (Network network : networks) {
            Integer confirm = network.getMinConfirm();
            if (minConfirm == null || (confirm != null && confirm < minConfirm)) {
                minConfirm = confirm;
            }
        }

        return minConfirm;
    }

    public Double getMinWithdrawFee() {

        Double minFee = null;

        for (Network network : networks) {
            Double fee = network.getWithdrawFee();
            if (minFee == null || (fee != null && fee < minFee)) {
                minFee = fee;
            }
        }

        return minFee;
    }
}