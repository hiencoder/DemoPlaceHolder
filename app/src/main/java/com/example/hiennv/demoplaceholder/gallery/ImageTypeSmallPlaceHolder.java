package com.example.hiennv.demoplaceholder.gallery;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.model.Image;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

@Animate(Animate.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.gallery_item_small_placeholder)
public class ImageTypeSmallPlaceHolder {
    @View(R.id.phv_item)
    PlaceHolderView phvItem;

    private Context context;
    private List<Image> images;

    public ImageTypeSmallPlaceHolder(Context context, List<Image> images) {
        this.context = context;
        this.images = images;
    }

    @Resolve
    public void onResolved() {
        phvItem.getBuilder()
                .setHasFixedSize(false)
                .setItemViewCacheSize(10)
                .setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        for (Image image :
                images) {
            phvItem.addView(new ImageTypeSmall(image.getUrl(), context, phvItem));
        }
    }
}
