package com.example.hiennv.demoplaceholder.infiniteplaceviewholder;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.model.feed.New;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.infinite.LoadMore;

import java.util.List;

@Layout(R.layout.load_more_view)
public class LoadMoreView {
    public static final int LOAD_VIEW_SET_COUNT = 6;
    private InfinitePlaceHolderView iphvLoadMore;
    private List<New> news;

    public LoadMoreView(InfinitePlaceHolderView iphvLoadMore, List<New> news) {
        this.iphvLoadMore = iphvLoadMore;
        this.news = news;
    }

    @LoadMore
    public void onLoadMore() {
        Log.d("DEBUG", "onLoadMore");
        new LoadMoreNew();
    }

    class LoadMoreNew implements Runnable {
        public LoadMoreNew() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                     int count = iphvLoadMore.getViewCount();
                    Log.d("DEBUG", "run: " + count);
                    for (int i = count - 1; i < (count - 1 + LoadMoreView.LOAD_VIEW_SET_COUNT) && news.size() > i; i++) {
                        iphvLoadMore.addView(new ItemNew(news.get(i),iphvLoadMore.getContext()));
                        if (i == news.size() - 1){
                            iphvLoadMore.noMoreToLoad();
                            break;
                        }
                    }
                    iphvLoadMore.loadingDone();

                }
            });
        }
    }
}
