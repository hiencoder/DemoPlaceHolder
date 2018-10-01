package com.example.hiennv.demoplaceholder.ui;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hiennv.demoplaceholder.R;
import com.example.hiennv.demoplaceholder.drawermenu.DrawerHeader;
import com.example.hiennv.demoplaceholder.drawermenu.DrawerMenuItem;
import com.example.hiennv.demoplaceholder.gallery.ImageTypeSmallPlaceHolder;
import com.example.hiennv.demoplaceholder.gallery.ItemTypeBig;
import com.example.hiennv.demoplaceholder.model.Image;
import com.example.hiennv.demoplaceholder.utils.CommonUtils;
import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DrawerMenuItem.DrawerMenuCallback {
    @BindView(R.id.phv_menu)
    PlaceHolderView phvMenu;

    @BindView(R.id.dl_main)
    DrawerLayout dlMain;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.phv_gallery)
    PlaceHolderView phvGallery;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnifeLite.bind(this);

        setupMenu();
        setupGallery();
    }

    //Setup gallery
    private void setupGallery() {
        List<Image> images = CommonUtils.loadListImage(this);
        for (Image image : images
                ) {
            Log.d("Url", "setupGallery: " + image.getUrl());
        }
        List<Image> newImageList = new ArrayList<>();
        for (int i = 0; i < ((images.size() > 10) ? 10 : images.size()); i++) {
            newImageList.add(images.get(i));
        }

        //Fetch place holder view
        phvGallery.addView(new ImageTypeSmallPlaceHolder(this, images));

        for (int i = newImageList.size() - 1; i >= 0; i--) {
            phvGallery.addView(new ItemTypeBig(this,newImageList.get(i).getUrl(),phvGallery));
        }
    }


    //Setup menu
    private void setupMenu() {
        phvMenu.addView(new DrawerHeader())
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this))
                .addView(new DrawerMenuItem(getApplicationContext(), this));
        drawerToggle = new ActionBarDrawerToggle(this, dlMain, toolbar, R.string.txt_open, R.string.txt_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        dlMain.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }


    @Override
    public void onProfileSelected() {
        Toast.makeText(this, "Profile Click!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestSelected() {
        Toast.makeText(this, "Request Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGroupSelected() {
        Toast.makeText(this, "Group Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMessageSelected() {
        Toast.makeText(this, "Message Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNotifySelected() {
        Toast.makeText(this, "Notify Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSettingSelected() {
        Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTermSeleted() {
        Toast.makeText(this, "Term Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogoutSeleted() {
        Toast.makeText(this, "Logout Click", Toast.LENGTH_SHORT).show();
    }
}
