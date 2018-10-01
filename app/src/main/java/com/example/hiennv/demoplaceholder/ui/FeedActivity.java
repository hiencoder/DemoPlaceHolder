package com.example.hiennv.demoplaceholder.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.feed.HeadingFeed;
import com.example.hiennv.demoplaceholder.feed.ItemFeed;
import com.example.hiennv.demoplaceholder.model.feed.New;
import com.example.hiennv.demoplaceholder.model.feed.Topic;
import com.example.hiennv.demoplaceholder.utils.CommonUtils;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.ephv_news)
    ExpandablePlaceHolderView ephvNews;

    List<Topic> topics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnifeLite.bind(this);
        topics = new ArrayList<>();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        topics = CommonUtils.loadTopic(this);
        for (Topic topic: topics){
            ephvNews.addView(new HeadingFeed(this,topic.getCategory()));
            for (New objNew : topic.getData()) {
                ephvNews.addView(new ItemFeed(this,objNew));
            }
        }
    }
}
