package com.hitbtc.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout HitBTC's API.
 */
@UtilityClass
public class HitbtcApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "hitbtc.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api." + BASE_DOMAIN;

    /**
     * ISO offset date time pattern.
     */
    public static final String ISO_OFFSET_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
}