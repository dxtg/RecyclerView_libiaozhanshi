package http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;

    public static RetrofitUtils getRetrofitUtils(){
        if(retrofitUtils==null){
            retrofitUtils=new RetrofitUtils();
        }
        return retrofitUtils;
    }

    public RetrofitUtils(){
        retrofit=new Retrofit.Builder()
                .baseUrl(HttpConfig.base_url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T createRequest(Class<T> clz){
        T t = retrofit.create(clz);
        return t;
    }
}
