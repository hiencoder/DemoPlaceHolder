package com.example.hiennv.demoplaceholder.ui;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.infiniteplaceviewholder.ItemNew;
import com.example.hiennv.demoplaceholder.infiniteplaceviewholder.LoadMoreView;
import com.example.hiennv.demoplaceholder.model.feed.New;
import com.example.hiennv.demoplaceholder.utils.CommonUtils;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.Comparator;
import java.util.List;

public class LoadMoreActivity extends AppCompatActivity {
    @BindView(R.id.iphv_news)
    InfinitePlaceHolderView iphvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more);
        ButterKnifeLite.bind(this);

        fetchData();
    }

    private void fetchData() {
        final List<New> news = CommonUtils.loadInfiniteNew(this);
        iphvNews.setLoadMoreResolver(new LoadMoreView(iphvNews,news));
        Log.d("DEBUG", "LoadMoreView.LOAD_VIEW_SET_COUNT " + LoadMoreView.LOAD_VIEW_SET_COUNT);
        for (int i = 0; i < LoadMoreView.LOAD_VIEW_SET_COUNT; i++) {
            iphvNews.addView(new ItemNew(news.get(i),this));
        }

        //Sort list
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                iphvNews.sort(new Comparator<Object>() {
                    @Override
                    public int compare(Object o, Object t1) {
                        //Sort title alphabet
                        if (o instanceof ItemNew && t1 instanceof ItemNew){
                            ItemNew itemNew1 = (ItemNew) o;
                            ItemNew itemNew2 = (ItemNew) t1;
                            return itemNew1.getObjNew().getTitle().compareTo(itemNew2.getObjNew().getTitle());
                        }
                        return 0;
                    }
                });
            }
        },8000);
    }
}
