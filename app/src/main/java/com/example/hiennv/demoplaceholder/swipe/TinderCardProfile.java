package com.example.hiennv.demoplaceholder.swipe;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.model.profile.Profile;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.tinder_card_view)
public class TinderCardProfile {
    @View(R.id.iv_profile)
    ImageView ivProfile;
    @View(R.id.tv_name_age)
    TextView tvNameAge;
    @View(R.id.tv_location)
    TextView tvLocation;

    private Context context;
    private Profile profile;
    private SwipePlaceHolderView swipePlaceHolderView;

    public TinderCardProfile(Context context, Profile profile, SwipePlaceHolderView swipePlaceHolderView) {
        this.context = context;
        this.profile = profile;
        this.swipePlaceHolderView = swipePlaceHolderView;
    }

    @Resolve
    public void onResolved() {
        Glide.with(context).load(profile.getUrl()).into(ivProfile);
        tvNameAge.setText(profile.getName() + "," + profile.getAge());
        tvLocation.setText(profile.getLocation());
    }

    @SwipeIn
    public void onSwipeIn() {
        Log.d("DEBUG", "onSwipeIn: ");
    }

    @SwipeInState
    public void onSwipeInState() {
        Log.d("DEBUG", "onSwipeInState: ");
    }

    @SwipeOut
    public void onSwipeOut() {
        swipePlaceHolderView.addView(this);
    }

    @SwipeOutState
    public void onSwipeOutState() {
        Log.d("DEBUG", "onSwipeOutState: ");
    }
}
