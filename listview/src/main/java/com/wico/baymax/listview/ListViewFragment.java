package com.wico.baymax.listview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.wico.baymax.refresh_view.PullToRefreshView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksii Shliama.
 */
public class ListViewFragment extends BaseRefreshFragment implements AbsListView.OnScrollListener {

    private SimpleAdapter simpleAdapter;
    private PullToRefreshView mPullToRefreshView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list_view, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setOnScrollListener(this);
        simpleAdapter = new SimpleAdapter(this.getActivity(),getDate(), R.layout.item,
                new String[]{"image","user_image","title","customer_image","content"},
                new int[]{R.id.image,R.id.image_user,R.id.title,R.id.image_customer,R.id.content});
        listView.setAdapter(simpleAdapter);

        mPullToRefreshView = (PullToRefreshView) rootView.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Map<String, Object> map;
                        map = new HashMap<String,Object>();
                        map.put(KEY_IMAGE, R.drawable.item_5);
                        map.put(KEY_IMAGE_USER, R.mipmap.lib_icon);
                        map.put(KEY_TITLE, "普吉岛艳遇");
                        map.put(KEY_IMAGE_CUSTOMSER, R.drawable.head);
                        map.put(KEY_CONTENT, "美丽的小岛，好漂亮啊！");
                        mSampleList.add(0,map);
                        simpleAdapter.notifyDataSetChanged();//update UI
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, REFRESH_DELAY);
            }
        });
        return rootView;
    }

    public List<Map<String, Object>> getDate(){
        return mSampleList;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE &&view.getLastVisiblePosition() == view.getCount()-1){
            if(view.getCount() < 20){
                new Thread(){
                    @Override
                    public void run() {
                        Map<String, Object> map;
                        map = new HashMap<String,Object>();
                        map.put(KEY_IMAGE, R.drawable.item_3);
                        map.put(KEY_IMAGE_USER, R.mipmap.lib_icon);
                        map.put(KEY_TITLE, "塞班岛艳遇");
                        map.put(KEY_IMAGE_CUSTOMSER, R.drawable.head);
                        map.put(KEY_CONTENT, "美丽的塞班，非常漂亮！");
                        mSampleList.add(map);
                        simpleAdapter.notifyDataSetChanged();//update UI
                    }
                }.run();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
