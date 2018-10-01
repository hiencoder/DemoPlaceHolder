package com.example.hiennv.demoplaceholder.gallery;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hiennv.demoplaceholder.R;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.LongClick;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Animate(Animate.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small)
public class ImageTypeSmall {
    @View(R.id.iv_item_small)
    ImageView ivItemSmall;

    private String url;
    private Context context;
    private PlaceHolderView placeHolderView;

    public ImageTypeSmall(String url, Context context, PlaceHolderView placeHolderView) {
        this.url = url;
        this.context = context;
        this.placeHolderView = placeHolderView;
    }

    @Resolve
    public void onResolved() {
        Glide.with(context).load(url).into(ivItemSmall);
    }

    @LongClick(R.id.iv_item_small)
    public void onLongClick(){
        //Remove image
        placeHolderView.removeView(this);
    }
}
