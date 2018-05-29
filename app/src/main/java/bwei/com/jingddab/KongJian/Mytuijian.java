package bwei.com.jingddab.KongJian;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwei.com.jingddab.BeanUtils.ShouyeBean;
import bwei.com.jingddab.R;

public class Mytuijian extends RecyclerView.Adapter<Mytuijian.Tuijianhodler>{
    private Context context;
    private List<ShouyeBean.TuijianBean.ListBean> list;

    public Mytuijian(Context context, List<ShouyeBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Tuijianhodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shouye_tuijian_zi, null);
        Tuijianhodler tuijianhodler=new Tuijianhodler(view);
        return tuijianhodler;
    }

    @Override
    public void onBindViewHolder(final Tuijianhodler holder, int position) {
        String images = list.get(position).getImages();
        String[] split = images.split(".jpg");
        holder.sd.setImageURI(split[0]+".jpg");
        holder.jiugongge_tv.setText(list.get(position).getPrice()+"");
        //给recycleView的item设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //索引
                int layoutPosition = holder.getLayoutPosition();

                //进行回调
                listener.itemClick(holder.itemView,layoutPosition);
            }
        });
    //长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //索引
                int layoutPosition = holder.getLayoutPosition();

                //进行回调
                listener.itemLongClick(holder.itemView,layoutPosition);

                return true;
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * recyclerView的监听事件
     */
    OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class Tuijianhodler extends RecyclerView.ViewHolder{
        public SimpleDraweeView sd;
        public TextView jiugongge_tv;
        public Tuijianhodler(View itemView) {
            super(itemView);
            this.sd=itemView.findViewById(R.id.sd);
            this.jiugongge_tv=itemView.findViewById(R.id.jiugongge_tv);
        }
    }

    interface OnItemClickListener{
        void  itemClick(View v,int position);
        void  itemLongClick(View v,int position);
    }

}
