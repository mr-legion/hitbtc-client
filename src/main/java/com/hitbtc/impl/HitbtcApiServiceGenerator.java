package com.hitbtc.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitbtc.HitbtcApiErrorResponse;
import com.hitbtc.exception.HitbtcApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static com.hitbtc.constant.HitbtcApiConstants.API_BASE_URL;

/**
 * Generates a HitBTC API implementation based on @see {@link HitbtcApiService}.
 */
public class HitbtcApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, HitbtcApiErrorResponse> errorBodyConverter =
            (Converter<ResponseBody, HitbtcApiErrorResponse>) converterFactory.responseBodyConverter(
                    HitbtcApiErrorResponse.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public HitbtcApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                HitbtcApiErrorResponse apiErrorResponse = getHitbtcApiError(response);
                throw new HitbtcApiException(apiErrorResponse.getError());
            }
        } catch (IOException e) {
            throw new HitbtcApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static HitbtcApiErrorResponse getHitbtcApiError(Response<?> response) throws IOException, HitbtcApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

}
