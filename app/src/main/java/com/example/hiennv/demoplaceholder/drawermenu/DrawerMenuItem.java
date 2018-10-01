package com.example.hiennv.demoplaceholder.drawermenu;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.demoplaceholder.R;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.drawer_item)
public class DrawerMenuItem {
    public static final int DRAWER_MENU_ITEM_PROFILE = 1;
    public static final int DRAWER_MENU_ITEM_REQUESTS = 2;
    public static final int DRAWER_MENU_ITEM_GROUP = 3;
    public static final int DRAWER_MENU_ITEM_MESSAGE = 4;
    public static final int DRAWER_MENU_ITEM_NOTIFY = 5;
    public static final int DRAWER_MENU_ITEM_SETTING = 6;
    public static final int DRAWER_MENU_ITEM_TERM = 7;
    public static final int DRAWER_MENU_ITEM_LOGOUT = 8;


    @Position
    int menuPos;
    @View(R.id.iv_item_menu)
    ImageView ivItemMenu;
    @View(R.id.tv_item_title)
    TextView tvItemTitle;

    private Context context;
    private DrawerMenuCallback drawerMenuCallback;

    //Constructor
    public DrawerMenuItem(Context context, DrawerMenuCallback drawerMenuCallback) {
        this.context = context;
        this.drawerMenuCallback = drawerMenuCallback;
    }

    //Fetch data menu
    @Resolve
    public void onResolved() {
        switch (menuPos) {
            case DRAWER_MENU_ITEM_PROFILE:
                tvItemTitle.setText("Profile");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_account_profile));
                break;
            case DRAWER_MENU_ITEM_REQUESTS:
                tvItemTitle.setText("Requests");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_request));
                break;
            case DRAWER_MENU_ITEM_GROUP:
                tvItemTitle.setText("Groups");
                ivItemMenu.setImageResource(R.drawable.ic_group);
                break;
            case DRAWER_MENU_ITEM_MESSAGE:
                tvItemTitle.setText("Messages");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_email));
                break;
            case DRAWER_MENU_ITEM_NOTIFY:
                tvItemTitle.setText("Notifications");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_notifications));
                break;
            case DRAWER_MENU_ITEM_SETTING:
                tvItemTitle.setText("Settings");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_setting));
                break;
            case DRAWER_MENU_ITEM_TERM:
                tvItemTitle.setText("Term");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_book));
                break;
            case DRAWER_MENU_ITEM_LOGOUT:
                tvItemTitle.setText("Logout");
                ivItemMenu.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_log_out));
                break;
        }
    }

    //Event Click menu
    @Click(R.id.mainView)
    public void onItemMenuClick() {
        switch (menuPos) {
            case DRAWER_MENU_ITEM_PROFILE:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onProfileSelected();
                }
                break;
            case DRAWER_MENU_ITEM_REQUESTS:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onRequestSelected();
                }
                break;
            case DRAWER_MENU_ITEM_GROUP:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onGroupSelected();
                }
                break;
            case DRAWER_MENU_ITEM_MESSAGE:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onMessageSelected();
                }

                break;
            case DRAWER_MENU_ITEM_NOTIFY:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onNotifySelected();
                }
                break;
            case DRAWER_MENU_ITEM_SETTING:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onSettingSelected();
                }
                break;
            case DRAWER_MENU_ITEM_TERM:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onTermSeleted();
                }
                break;
            case DRAWER_MENU_ITEM_LOGOUT:
                if (drawerMenuCallback != null) {
                    drawerMenuCallback.onLogoutSeleted();
                }
                break;
        }
    }

    public void setDrawerMenuCallback(DrawerMenuCallback drawerMenuCallback) {
        this.drawerMenuCallback = drawerMenuCallback;
    }

    public interface DrawerMenuCallback {
        void onProfileSelected();

        void onRequestSelected();

        void onGroupSelected();

        void onMessageSelected();

        void onNotifySelected();

        void onSettingSelected();

        void onTermSeleted();

        void onLogoutSeleted();
    }
}
