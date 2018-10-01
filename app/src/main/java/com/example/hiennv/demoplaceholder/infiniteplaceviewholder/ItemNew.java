package com.example.hiennv.demoplaceholder.infiniteplaceviewholder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.model.feed.New;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.load_more_item_view)
public class ItemNew {
    @View(R.id.iv_cap)
    ImageView ivCap;
    @View(R.id.tv_title)
    TextView tvTitle;
    @View(R.id.tv_caption)
    TextView tvCaption;
    @View(R.id.tv_time_posted)
    TextView tvTimePosted;
    @View(R.id.cv_item_new)
    CardView cvItemNew;

    private New objNew;
    private Context context;

    public ItemNew(New objNew, Context context) {
        this.objNew = objNew;
        this.context = context;
    }

    @Resolve
    public void onResolved(){
        Glide.with(context).load(objNew.getImageUrl()).into(ivCap);
        tvTitle.setText(objNew.getTitle());
        tvCaption.setText(objNew.getCaption());
        tvTimePosted.setText(objNew.getTime());
    }

    public New getObjNew() {
        return objNew;
    }

    //Event click
    @Click(R.id.cv_item_new)
    public void onClick(){
        Toast.makeText(context, objNew.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
