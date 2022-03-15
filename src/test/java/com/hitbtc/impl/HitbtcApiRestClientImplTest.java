package com.hitbtc.impl;

import com.hitbtc.HitbtcApiClientFactory;
import com.hitbtc.HitbtcApiRestClient;
import com.hitbtc.domain.general.Asset;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HitbtcApiRestClientImplTest {

    private final HitbtcApiRestClient hitbtcApiRestClient = HitbtcApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Map<String, Asset> assets = hitbtcApiRestClient.getAssets();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}