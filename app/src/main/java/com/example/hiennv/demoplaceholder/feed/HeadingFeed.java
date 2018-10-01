package com.example.hiennv.demoplaceholder.feed;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hiennv.demoplaceholder.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.Collapse;
import com.mindorks.placeholderview.annotations.expand.Expand;
import com.mindorks.placeholderview.annotations.expand.Parent;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.mindorks.placeholderview.annotations.expand.SingleTop;

@Parent
@SingleTop
@Layout(R.layout.feed_heading)
public class HeadingFeed {
    @View(R.id.ll_toggle_view)
    LinearLayout llToggleView;

    @View(R.id.tv_heading)
    TextView tvHeading;

    @View(R.id.iv_toggle)
    ImageView ivToggle;

    @ParentPosition
    int parentPos;

    private Context context;
    private String category;

    public HeadingFeed(Context context, String category) {
        this.context = context;
        this.category = category;
    }

    //Fetch data
    @Resolve
    public void onResolved(){
        tvHeading.setText(category);
        ivToggle.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_down));
    }

    @Expand
    public void onExpand(){
        ivToggle.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_up));
    }

    @Collapse
    public void onCollapse(){
        ivToggle.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_down));
    }


}
