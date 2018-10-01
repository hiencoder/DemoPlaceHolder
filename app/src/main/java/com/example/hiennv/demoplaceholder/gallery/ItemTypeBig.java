package com.example.hiennv.demoplaceholder.gallery;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hiennv.demoplaceholder.R;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.LongClick;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Recycle;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Animate(Animate.ENTER_LEFT_DESC)
@NonReusable
@Layout(R.layout.gallery_item_big)
public class ItemTypeBig {
    @View(R.id.iv_item_big)
    ImageView ivItemBig;

    @Position
    int position;

    private Context context;
    private String url;
    private PlaceHolderView placeHolderView;

    public ItemTypeBig(Context context, String url, PlaceHolderView placeHolderView) {
        this.context = context;
        this.url = url;
        this.placeHolderView = placeHolderView;
    }

    @Resolve
    public void onResolved() {
        Glide.with(context).load(url).into(ivItemBig);
        Log.d("Debug", "onRecycled: " + position);
    }

    /*@Recycle
    public void onRecycled() {
        Log.d("Debug", "onRecycled: " + position);
        Glide.with(context).load(url).into(ivItemBig);
    }*/

    @LongClick(R.id.iv_item_big)
    public void onLongClick() {
        placeHolderView.removeView(this);
    }
}
