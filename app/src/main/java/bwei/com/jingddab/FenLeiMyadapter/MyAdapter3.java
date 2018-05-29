package bwei.com.jingddab.FenLeiMyadapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwei.com.jingddab.BeanUtils.RightBean;
import bwei.com.jingddab.R;
import bwei.com.jingddab.ShangPLBActivity;

/**
 * GridView的适配器
 */

public class MyAdapter3 extends BaseAdapter {

    private Context context;
    private List<RightBean.DataBean.ListBean> list;
    public MyAdapter3(Context context, List<RightBean.DataBean.ListBean> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyViewHolder2 myViewHolder2=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.gv_item,null);
            ImageView imageView = convertView.findViewById(R.id.gv_pic);
            TextView textView = convertView.findViewById(R.id.gv_name);

            myViewHolder2= new MyViewHolder2(imageView,textView);

            convertView.setTag(myViewHolder2);





        }
        else {
            myViewHolder2= (MyViewHolder2) convertView.getTag();
        }
        //赋值
        myViewHolder2.getGv_tv().setText(list.get(position).getName());
        //
        Glide.with(context).load(list.get(position).getIcon()).into(myViewHolder2.getGv_pic());

        myViewHolder2.gv_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShangPLBActivity.class);
                /*intent.putExtra("pscid",list.get(position).getPscid());
                intent.putExtra("icon",list.get(position).getIcon());
                intent.putExtra("name",list.get(position).getName());*/
                context.startActivity(intent);
            }
        });
        return convertView;
    }


    class MyViewHolder2{
        private ImageView gv_pic;
        private TextView gv_tv;

        public MyViewHolder2(ImageView gv_pic, TextView gv_tv) {
            this.gv_pic = gv_pic;
            this.gv_tv = gv_tv;
        }

        public ImageView getGv_pic() {
            return gv_pic;
        }

        public void setGv_pic(ImageView gv_pic) {
            this.gv_pic = gv_pic;
        }

        public TextView getGv_tv() {
            return gv_tv;
        }

        public void setGv_tv(TextView gv_tv) {
            this.gv_tv = gv_tv;
        }
    }
}
