package model;

import android.util.Log;

import java.util.Map;

import http.MyService;
import http.RetrofitUtils;
import presenter.IPresenter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public class GoodsModel implements IModel {
    private static final String TAG="GoodsModel---";
    private IPresenter iPresenter;

    public GoodsModel(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public void getGoodsData(Map<String, String> map) {
        //使用Retrofit请求网络
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        MyService myService = retrofitUtils.createRequest(MyService.class);
        myService.getGoods(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodsBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "完成===========");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: 异常"+e);
                    }

                    @Override
                    public void onNext(FoodsBean foodsBean) {
                        Log.d(TAG, "onNext: "+foodsBean);
                        //调用p层getGoodsListData()方法，得到数据
                        iPresenter.getGoodsListData(foodsBean.getData());
                    }
                });

    }
}
