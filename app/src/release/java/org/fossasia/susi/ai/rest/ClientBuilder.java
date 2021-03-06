package org.dungpham.susi.ai.rest;

import org.dungpham.susi.ai.helper.PrefManager;
import org.dungpham.susi.ai.rest.interceptors.TokenInterceptor;
import org.dungpham.susi.ai.rest.services.SusiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saurabh on 1/10/16.
 * <p>
 * Singleton class to get Susi client.
 */
public class ClientBuilder {

    private static Retrofit retrofit;
    private static SusiService susiService;

    /**
     * Instantiates a new Client builder.
     */
    public ClientBuilder() {
        createSusiService();
    }

    private static void init() {
        susiService = createApi(SusiService.class);
    }

    private static <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    /**
     * Create susi service.
     */
    public static void createSusiService() {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new TokenInterceptor());

        retrofit = new Retrofit.Builder()
                .baseUrl(PrefManager.getSusiRunningBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        init();
    }

    /**
     * Gets susi api.
     *
     * @return the susi api
     */
    public SusiService getSusiApi() {
        return susiService;
    }
}
