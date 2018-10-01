package com.example.hiennv.demoplaceholder;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.LongClick;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;


@Animate(Animate.ENTER_LEFT_DESC)
@NonReusable
@Layout(R.layout.item_gallery_big) //Add layout cho class
public class ItemTypeBig {
    @View(R.id.iv_item)
    ImageView ivItem;

    private String mUrl;
    private Context mContext;
    private PlaceHolderView mPlaceHolderView;

    public ItemTypeBig(Context context, PlaceHolderView placeHolderView, String url){
        this.mContext = context;
        this.mPlaceHolderView = placeHolderView;
        this.mUrl = url;
    }

    @Resolve
    public void onResolved(){
        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(mContext).applyDefaultRequestOptions(requestOptions).load(mUrl).into(ivItem);
    }

    @LongClick(R.id.iv_item)
    public void onLongClick(){
        mPlaceHolderView.removeView(this);
    }


    //Annotation
    //@View: Bind bien duoc dinh nghia vs view o tren
    //@Click: Bind su kien click OnClickListener vao View.
    //@LongClick: Bind su kien LongClick vao view.
    //@Resolve:
    //@Animate: Thiet lap hieu ung cho item view
    //@NonReusable: Giai phong view
}
