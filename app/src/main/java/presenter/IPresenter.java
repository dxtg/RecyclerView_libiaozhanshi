package presenter;

import java.util.List;

import model.FoodsBean;
import model.GoodsModel;
import view.IView;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public interface IPresenter {
    void showGoodsToView(GoodsModel goodsModel, IView iView);
    void getGoodsListData(List<FoodsBean.DataBean> data);
}
