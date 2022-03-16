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

    @JsonProperty("payinEnabled")
    private Boolean depositEnabled;

    @JsonProperty("payoutEnabled")
    private Boolean withdrawEnabled;

    private Boolean transferEnabled;

    @JsonProperty("precision_transfer")
    private Double precisionTransfer;

    private List<Network> networks;

}