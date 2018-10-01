package com.example.hiennv.demoplaceholder.feed;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.model.feed.New;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

@Layout(R.layout.feed_item)
public class ItemFeed {
    @View(R.id.ll_item)
    LinearLayout llItem;
    @View(R.id.iv_cap)
    ImageView ivCap;
    @View(R.id.tv_title)
    TextView tvTitle;
    @View(R.id.tv_caption)
    TextView tvCaption;
    @View(R.id.tv_time_posted)
    TextView tvTimePosted;

    @ParentPosition
    int parentPos;

    @ChildPosition
    int childPos;

    private Context context;
    private New objNew;

    public ItemFeed(Context context, New objNew) {
        this.context = context;
        this.objNew = objNew;
    }

    //Fetch data
    @Resolve
    public void onResolved(){
        Glide.with(context).load(objNew.getImageUrl()).into(ivCap);
        tvTitle.setText(objNew.getTitle());
        tvCaption.setText(objNew.getCaption());
        tvTimePosted.setText(objNew.getTime());
    }

    @Click(R.id.ll_item)
    public void onClick(){
        Toast.makeText(context, objNew.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
