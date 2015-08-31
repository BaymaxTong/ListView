package com.wico.baymax.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksii Shliama.
 */
public class BaseRefreshFragment extends Fragment {

    public static final int REFRESH_DELAY = 2000;

    public static final String KEY_IMAGE = "image";
    public static final String KEY_IMAGE_USER = "user_image";
    public static final String KEY_TITLE = "title";
    public static final String KEY_IMAGE_CUSTOMSER = "customer_image";
    public static final String KEY_CONTENT = "content";

    protected List<Map<String, Object>> mSampleList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<String, Object> map;
        mSampleList = new ArrayList<Map<String,Object>>();

        int[] icons = {
                R.drawable.item_1,
                R.drawable.item_2,
                R.drawable.item_3,
                R.drawable.item_4,
                R.drawable.item_5,
                R.drawable.item_6,
                R.drawable.item_7};

        int[] colors = {
                R.color.saffron,
                R.color.eggplant,
                R.color.sienna};

        for (int i = 0; i < icons.length; i++) {
            map = new HashMap<String,Object>();
            map.put(KEY_IMAGE, icons[i]);
            map.put(KEY_IMAGE_USER, R.mipmap.lib_icon);
            map.put(KEY_TITLE, "美丽的风景");
            map.put(KEY_IMAGE_CUSTOMSER, R.drawable.head);
            map.put(KEY_CONTENT, "哇哇哇，好漂亮啊！好想去啊");
            mSampleList.add(map);
        }
    }
}
