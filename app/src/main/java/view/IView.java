package view;

import java.util.List;

import model.FoodsBean;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public interface IView {
    //显示数据
    void showData(List<FoodsBean.DataBean> list);
}
