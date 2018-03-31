package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bawei.com.recyclerview_libiaozhanshi.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import model.FoodsBean;
import model.GoodsModel;
import presenter.GoodsPresenter;

public class MainActivity extends AppCompatActivity implements IView {
    private static final String TAG = "MainActivity----";
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.center)
    TextView center;
    @BindView(R.id.clear)
    TextView clear;
    @BindView(R.id.goodslist)
    RecyclerView goodslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化数据
        initData();
    }

    private void initData() {
        //初始化recyclerview
        goodslist.setLayoutManager(new LinearLayoutManager(this));

        //调用p层
        GoodsPresenter goodsPresenter=new GoodsPresenter();
        goodsPresenter.showGoodsToView(new GoodsModel(goodsPresenter),this);

    }

    //显示商品列表
    @Override
    public void showData(List<FoodsBean.DataBean> list) {
        Log.d(TAG, "showData: "+list);

        //设置适配器
        MyAdapter myAdapter=new MyAdapter(list,MainActivity.this);
        goodslist.setAdapter(myAdapter);

    }

    @OnClick(R.id.clear)
    public void onViewClicked() {
    }
}
