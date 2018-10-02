package com.example.hiennv.demoplaceholder.expandable;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hiennv.demoplaceholder.R;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

import java.util.ArrayList;
import java.util.List;

@Layout(R.layout.drawer_item)
public class ChildItem {
    @ParentPosition
    int parentPos;
    @ChildPosition
    int childPos;

    @View(R.id.iv_item_menu)
    ImageView ivItem;

    @View(R.id.tv_item_title)
    TextView tvItemTitle;

    @View(R.id.mainView)
    LinearLayout llMainView;

    private ExpandablePlaceHolderView expandablePlaceHolderView;
    //List data
    private List<List<String>> titles;

    public ChildItem(ExpandablePlaceHolderView expandablePlaceHolderView){
        this.expandablePlaceHolderView = expandablePlaceHolderView;
        titles = new ArrayList<>();

        List<String> title1 = new ArrayList<>();
        title1.add("a");
        title1.add("b");
        title1.add("c");
        title1.add("d");
        title1.add("e");

        List<String> title2 = new ArrayList<>();
        title2.add("aa");
        title2.add("ab");
        title2.add("ac");
        title2.add("ad");
        title2.add("ae");


        List<String> title3 = new ArrayList<>();
        title3.add("aa");
        title3.add("bb");
        title3.add("cc");
        title3.add("dd");
        title3.add("ee");


        List<String> title4 = new ArrayList<>();
        title4.add("aaaa");
        title4.add("bbbb");
        title4.add("cccc");
        title4.add("dddd");
        title4.add("eeee");


        List<String> title5 = new ArrayList<>();
        title4.add("aaaaa");
        title4.add("bbbbb");
        title4.add("ccccc");
        title4.add("ddddd");
        title4.add("eeeee");


        List<String> title6 = new ArrayList<>();
        title4.add("aaaaaa");
        title4.add("bbbbbb");
        title4.add("cccccc");
        title4.add("dddddd");
        title4.add("eeeeee");


        List<String> title7 = new ArrayList<>();
        title4.add("aaaaaaa");
        title4.add("bbbbbbb");
        title4.add("ccccccc");
        title4.add("ddddddd");
        title4.add("eeeeeee");


        List<String> title8 = new ArrayList<>();
        title4.add("aaaaaaaa");
        title4.add("bbbbbbbb");
        title4.add("cccccccc");
        title4.add("dddddddd");
        title4.add("eeeeeeee");


        titles.add(title1);
        titles.add(title2);
        titles.add(title3);
        titles.add(title4);
        titles.add(title5);
        titles.add(title6);
        titles.add(title7);
        titles.add(title8);
    }

    @Resolve
    public void onResolved(){
        //Set background
        llMainView.setBackgroundColor(Color.GRAY);
        //Set image child item
        ivItem.setImageDrawable(expandablePlaceHolderView.getResources().getDrawable(R.drawable.ic_book));
        //Set title
        tvItemTitle.setText(titles.get(parentPos).get(childPos));
    }

    @Click(R.id.mainView)
    public void onClick(){
        expandablePlaceHolderView.removeView(this);
    }
}
