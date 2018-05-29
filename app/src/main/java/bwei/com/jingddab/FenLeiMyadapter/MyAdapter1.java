package bwei.com.jingddab.FenLeiMyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import bwei.com.jingddab.BeanUtils.LeftBean;
import bwei.com.jingddab.R;

/**
 * Created by gjl on 2018/4/29.
 */

public class MyAdapter1 extends BaseAdapter {
    private Context context;
    private List<LeftBean.DataBean> list;
    public MyAdapter1(Context context,List<LeftBean.DataBean> list){
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
        MyViewHolder myViewHolder=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.left_item,null);
            TextView textView = convertView.findViewById(R.id.left_item_tv);

            myViewHolder=new MyViewHolder(textView);

            convertView.setTag(myViewHolder);


        }
        else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        myViewHolder.getTextView().setText(list.get(position).getName());
        return convertView;
    }
    class MyViewHolder{
        private TextView textView;

        public MyViewHolder(TextView textView) {
            this.textView = textView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }
}
