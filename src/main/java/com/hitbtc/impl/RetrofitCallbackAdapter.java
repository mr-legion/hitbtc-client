package com.hitbtc.impl;

import com.hitbtc.HitbtcApiErrorResponse;
import com.hitbtc.exception.HitbtcApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.hitbtc.impl.HitbtcApiServiceGenerator.getHitbtcApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                HitbtcApiErrorResponse apiError = getHitbtcApiError(response);
                onFailure(call, new HitbtcApiException(apiError.getError()));
            } catch (IOException e) {
                onFailure(call, new HitbtcApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof HitbtcApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new HitbtcApiException(t));
        }
    }
}
