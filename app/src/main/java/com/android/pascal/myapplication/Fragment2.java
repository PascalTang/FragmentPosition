package com.android.pascal.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends android.support.v4.app.Fragment{
    private static String ARG_PARAM = "param_key";
    private String mParam;
    private Activity mActivity;

    private String[] str = {
    };

    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mParam = getArguments().getString(ARG_PARAM);  //获取参数
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_1, container, false);
        MyRecycleView rv = root.findViewById(R.id.rv);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);

        rv.setAdapter(new MyAdapter(str));
//        view.setText(mParam);




        return root;
    }
    public static Fragment2 newInstance(String str) {
        Fragment2 frag = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, str);
        frag.setArguments(bundle);   //设置参数
        return frag;
    }
}