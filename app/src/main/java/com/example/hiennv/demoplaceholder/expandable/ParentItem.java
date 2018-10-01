package com.example.hiennv.demoplaceholder.expandable;

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
import com.mindorks.placeholderview.annotations.expand.Toggle;

import java.util.ArrayList;
import java.util.List;

@Parent
@SingleTop
@Layout(R.layout.drawer_item)
public class ParentItem {
    @ParentPosition
    int parentPos;

    @Toggle(R.id.iv_item_menu)
    @View(R.id.iv_item_menu)
    ImageView ivItemMenu;

    @View(R.id.tv_item_title)
    TextView tvItemTile;

    @View(R.id.mainView)
    LinearLayout llMainView;

    private List<String> list;

    private Context context;
    public ParentItem(Context context){
        //Tao parent item
        this.context = context;
        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Mango");
        list.add("Papaya");
        list.add("Lemon");
        list.add("StrawBerry");
        list.add("WolfBerry");
        list.add("Apple");
        list.add("Apple");
        list.add("Apple");
        list.add("Apple");
    }

    @Resolve
    public void onResolved(){
        //toggle collapse
        ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_down));
    }

    @Collapse
    public void onCollapse(){
        ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_up));
    }

    @Expand
    public void onExpand(){
        ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_down));
    }
}
