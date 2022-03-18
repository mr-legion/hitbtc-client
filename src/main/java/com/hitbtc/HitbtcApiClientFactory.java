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
        this.serviceGenerator = new HitbtcApiServiceGenerator(new OkHttpClient());
    }

    public HitbtcApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    private HitbtcApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new HitbtcApiServiceGenerator(newClient);
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
