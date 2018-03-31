package http;

import java.util.Map;

import model.FoodsBean;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public interface MyService {

    @FormUrlEncoded
    @POST("product/getCarts")
    Observable<FoodsBean> getGoods(@FieldMap Map<String,String> map);
}
