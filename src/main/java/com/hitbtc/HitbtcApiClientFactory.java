package com.hitbtc;

import com.hitbtc.impl.HitbtcApiAsyncRestClientImpl;
import com.hitbtc.impl.HitbtcApiRestClientImpl;
import com.hitbtc.impl.HitbtcApiService;
import com.hitbtc.impl.HitbtcApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating HitBTC API client objects.
 */
public class HitbtcApiClientFactory {

    private final HitbtcApiServiceGenerator serviceGenerator;

    public HitbtcApiClientFactory() {
        this(new OkHttpClient());
    }

    private HitbtcApiClientFactory(OkHttpClient client) {
        this.serviceGenerator = new HitbtcApiServiceGenerator(client);
    }

    /**
     * New instance without authentication.
     *
     * @return the HitBTC API client factory
     */
    public static HitbtcApiClientFactory newInstance() {
        return new HitbtcApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public HitbtcApiRestClient newRestClient() {
        return new HitbtcApiRestClientImpl(serviceGenerator.createService(HitbtcApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public HitbtcApiAsyncRestClient newAsyncRestClient() {
        return new HitbtcApiAsyncRestClientImpl(serviceGenerator.createService(HitbtcApiService.class));
    }
}
