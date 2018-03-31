package presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FoodsBean;
import model.GoodsModel;
import view.IView;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public class GoodsPresenter implements IPresenter {
    private IView iView;

    @Override
    public void showGoodsToView(GoodsModel goodsModel, IView iView) {
        this.iView=iView;

        Map<String,String> map=new HashMap<>();
        map.put("uid","71");

        //调用model层里请求网络的方法
        goodsModel.getGoodsData(map);
    }

    @Override
    public void getGoodsListData(List<FoodsBean.DataBean> data) {
       //调用v层显示数据的方法
        iView.showData(data);
    }
}
