package com.hitbtc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

/**
 * HitBTC API error response.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HitbtcApiErrorResponse {

    @JsonProperty("timestamp")
    private Date date;

    private HitbtcApiError error;

    private String path;
    private String requestId;

}
