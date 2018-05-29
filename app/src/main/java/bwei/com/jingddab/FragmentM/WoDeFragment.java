package bwei.com.jingddab.FragmentM;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import bwei.com.jingddab.R;
import bwei.com.jingddab.Wode_dlzc;

public class WoDeFragment extends Fragment {
    private ImageView toux;
    private TextView yhm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.wode, container, false);
        initView(view);
        TextView yhm =  view.findViewById(R.id.yhm);
        yhm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Wode_dlzc.class);
                startActivity(intent);
            }
        });

        toux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private void initView(@NonNull final View view) {
        toux = (ImageView) view.findViewById(R.id.toux);
        yhm = (TextView) view.findViewById(R.id.yhm);

    }
}
