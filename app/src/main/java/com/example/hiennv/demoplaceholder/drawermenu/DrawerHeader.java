package com.example.hiennv.demoplaceholder.drawermenu;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.demoplaceholder.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Recycle;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.drawer_header)
public class DrawerHeader {
    private static final String TAG = DrawerHeader.class.getSimpleName();
    //bind view
    @View(R.id.iv_profile)
    ImageView ivProfile;

    @View(R.id.tv_name)
    TextView tvName;

    @View(R.id.tv_email)
    TextView tvEmail;

    //fetch user info
    @Resolve
    public void onResolved(){
        tvName.setText("Hien abc");
        tvEmail.setText("Mrphonglinh2605@gmail.com");
    }

    @Recycle
    public void recycler(){
        Log.i(TAG, "recycler: ");
    }
}
