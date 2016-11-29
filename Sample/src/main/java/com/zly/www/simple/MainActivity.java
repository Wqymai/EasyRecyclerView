package com.zly.www.simple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zly.www.easyrecyclerview.EasyRecyclerView;
import com.zly.www.easyrecyclerview.listener.ItemClickSupport;
import com.zly.www.simple.adapter.RvAdapter;
import com.zly.www.simple.customall.CustomAllActivity;
import com.zly.www.simple.itemstick.ItemStickActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zly on 2016/11/28 0028.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.erv)
    EasyRecyclerView erv;

    private RvAdapter mAdapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        erv.setLayoutManager(new GridLayoutManager(this,3));
        erv.setAdapter(mAdapter = new RvAdapter());

        ItemClickSupport.addTo(erv.getRecyclerView()).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,CustomAllActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,ItemStickActivity.class));
                        break;
                }
            }
        });
    }

    private void initData() {
        mAdapter.add("定制头部和底部");
        mAdapter.add("顶部吸附");
    }


}
