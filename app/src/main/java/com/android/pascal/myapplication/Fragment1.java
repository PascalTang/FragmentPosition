package com.android.pascal.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends android.support.v4.app.Fragment {
    private static String ARG_PARAM = "param_key";
    private int mParam;
    private Activity mActivity;
    private MyRecycleView rv;
    private String[] str = {
            "1", "2", "3", "4", "5",
            "a", "b", "c", "d", "e",
            "3", "3", "3", "3", "3",
            "4", "4", "4", "4", "4",
            "5", "5", "5", "5", "5",
            "6", "6", "6", "6", "6",
            "7", "7", "7", "7", "7"
    };

    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        assert getArguments() != null;
        mParam = getArguments().getInt(ARG_PARAM);  //获取参数
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_1, container, false);
        rv = root.findViewById(R.id.rv);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);

        rv.setAdapter(new MyAdapter(str));
        rv.scrollToPosition(mParam);
//        view.setText(mParam);
        return root;
    }

    public static Fragment1 newInstance(int position) {
        Fragment1 frag = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PARAM, position);
        frag.setArguments(bundle);   //设置参数
        return frag;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LinearLayoutManager myLayoutManager = (LinearLayoutManager) rv.getLayoutManager();
        int scrollPosition = myLayoutManager.findFirstVisibleItemPosition();

        MainActivity activity = (MainActivity)getActivity();
        assert activity != null;
        activity.setPosition(scrollPosition);
        Log.i("ccc", "scrollPosition " + scrollPosition);

    }
}