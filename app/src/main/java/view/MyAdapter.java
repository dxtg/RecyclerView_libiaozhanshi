package view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bawei.com.recyclerview_libiaozhanshi.R;
import model.FoodsBean;

/**
 * Created by 杜晓彤 on 2018/3/31.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<FoodsBean.DataBean> list;
    private Context context;
    public static final String TAG="MyAdapter------";

    private List<FoodsBean.ChildBean> c_list=new ArrayList<>();
    public MyAdapter(List<FoodsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        //需要筛选一下，将复合天剑的集合数据，添加到一个新的集合里
            for(int i=0;i<list.size();i++){
                List<FoodsBean.ChildBean> list1 = list.get(i).getList();
                if(list1!=null&&list1.size()>0){
                    c_list.addAll(list1);
                }
            }
        }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.getItem_title().setText(c_list.get(position).getTitle());
        holder.getItem_time().setText(c_list.get(position).getCreatetime());

        String images = c_list.get(position).getImages();
        String image_url = images.split("\\|")[0];
        holder.getItem_pic().setImageURI(image_url);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+c_list.size());
        return c_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView item_pic;
        private final TextView item_title;
        private final TextView item_time;

        public SimpleDraweeView getItem_pic() {
            return item_pic;
        }

        public TextView getItem_title() {
            return item_title;
        }

        public TextView getItem_time() {
            return item_time;
        }

        public MyViewHolder(View itemView) {
            super(itemView);

            //找控件
            item_pic = itemView.findViewById(R.id.item_pic);
            item_title = itemView.findViewById(R.id.item_title);
            item_time = itemView.findViewById(R.id.item_time);


        }
    }
}
