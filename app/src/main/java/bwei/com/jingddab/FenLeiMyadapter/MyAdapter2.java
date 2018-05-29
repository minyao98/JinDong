package bwei.com.jingddab.FenLeiMyadapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import bwei.com.jingddab.BeanUtils.RightBean;
import bwei.com.jingddab.R;
import bwei.com.jingddab.ShangPLBActivity;

/**
 * Created by gjl on 2018/4/29.
 */

public class MyAdapter2 extends BaseAdapter {

    private Context context;
    private List<RightBean.DataBean> list;
    public MyAdapter2(Context context,List<RightBean.DataBean> list){
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
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder2 myViewHolder2=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.right_item_layout,null);
            TextView right_title = convertView.findViewById(R.id.right_title);
            GridView right_gv = convertView.findViewById(R.id.right_gv);

            myViewHolder2= new MyViewHolder2(right_title,right_gv);

            convertView.setTag(myViewHolder2);

        }
        else {
            myViewHolder2= (MyViewHolder2) convertView.getTag();
        }
        //赋值
        myViewHolder2.getRight_tv().setText(list.get(position).getName());
        //
        List<RightBean.DataBean.ListBean> list = this.list.get(position).getList();
        MyAdapter3 myAdapter3 = new MyAdapter3(context, list);
        myViewHolder2.getRight_gv().setAdapter(myAdapter3);

        return convertView;
    }
    class MyViewHolder2{
        private TextView right_tv;
        private GridView right_gv;

        public MyViewHolder2(TextView right_tv, GridView right_gv) {
            this.right_tv = right_tv;
            this.right_gv = right_gv;
        }

        public TextView getRight_tv() {
            return right_tv;
        }

        public void setRight_tv(TextView right_tv) {
            this.right_tv = right_tv;
        }

        public GridView getRight_gv() {
            return right_gv;
        }

        public void setRight_gv(GridView right_gv) {
            this.right_gv = right_gv;
        }
    }
}
