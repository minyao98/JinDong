package bwei.com.jingddab.KongJian;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwei.com.jingddab.BeanUtils.ShangplbBean;
import bwei.com.jingddab.R;

public class MyAdapter extends RecyclerView.Adapter{
    private String url = "https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg";

    Context context;
    List<ShangplbBean.DataBean> list;
    public MyAdapter(Context context, List<ShangplbBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.sahngplb_item,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText(list.get(position).getPrice()+"");
        Glide.with(context).load(url).into(viewHolder.img);
        //给recycleView的item设置点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //索引
                int layoutPosition = viewHolder.getLayoutPosition();

                //进行回调
                listener.itemClick(viewHolder.itemView,layoutPosition);
            }
        });
        //长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //索引
                int layoutPosition = viewHolder.getLayoutPosition();

                //进行回调
                listener.itemLongClick(viewHolder.itemView,layoutPosition);

                return true;
            }
        });
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


     //recyclerView的监听事件
   OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv1,tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv2=itemView.findViewById(R.id.tv2);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
    public interface OnItemClickListener{
        void  itemClick(View v,int position);
        void  itemLongClick(View v,int position);
    }

}

