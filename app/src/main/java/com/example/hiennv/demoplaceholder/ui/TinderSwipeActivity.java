package com.example.hiennv.demoplaceholder.ui;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.model.profile.Profile;
import com.example.hiennv.demoplaceholder.swipe.TinderCardProfile;
import com.example.hiennv.demoplaceholder.utils.CommonUtils;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.butterknifelite.annotations.OnClick;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.List;

public class TinderSwipeActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.sphv_tinder)
    SwipePlaceHolderView swipePlaceHolderView;

    private List<Profile> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_swipe);
        ButterKnifeLite.bind(this);
        profiles = CommonUtils.loadProfiles(this);
        /*swipePlaceHolderView.getBuilder()
                .setDisplayViewCount(4) //so luong item hien thi
                .setSwipeDecor(new SwipeDecor()
                .setPaddingTop(20)
                .setRelativeScale(0.01f)
                .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));*/
        int bottomMargin = CommonUtils.dpToPx(160);
        Point windowSize = CommonUtils.getDisplaySize(getWindowManager());

        swipePlaceHolderView.getBuilder()
                .setDisplayViewCount(4) //so luong item hien thi
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth(windowSize.x)
                        .setViewHeight(windowSize.y - bottomMargin)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setViewGravity(Gravity.TOP)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));
        //Add view
        for (Profile profile : profiles) {
            swipePlaceHolderView.addView(new TinderCardProfile(this, profile, swipePlaceHolderView));
        }

    }

    @OnClick(R.id.btn_fav)
    public void handleFav() {
        swipePlaceHolderView.doSwipe(true);
    }

    @OnClick(R.id.btn_cancel)
    public void handleCancel() {
        swipePlaceHolderView.doSwipe(false);
    }
}
