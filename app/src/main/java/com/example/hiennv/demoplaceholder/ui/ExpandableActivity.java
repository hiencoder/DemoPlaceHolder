package com.example.hiennv.demoplaceholder.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.expandable.ChildItem;
import com.example.hiennv.demoplaceholder.expandable.ParentItem;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.butterknifelite.annotations.OnClick;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;

public class ExpandableActivity extends AppCompatActivity {
    @BindView(R.id.ephv_sample)
    ExpandablePlaceHolderView ephvSample;

    //ParentItem expand/collapse
    ParentItem parentItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        ButterKnifeLite.bind(this);
        parentItem = new ParentItem(this);
        ephvSample.addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(parentItem)
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))

                .addView(new ParentItem(this))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample))
                .addView(new ChildItem(ephvSample));
    }

    //Event button
    @OnClick(R.id.btn_expand)
    public void expand(){
        ephvSample.expand(parentItem);
    }

    @OnClick(R.id.btn_collapse)
    public void collapse(){
        ephvSample.collapse(parentItem);
    }
}
