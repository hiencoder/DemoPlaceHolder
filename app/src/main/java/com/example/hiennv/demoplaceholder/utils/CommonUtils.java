package com.example.hiennv.demoplaceholder.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.example.hiennv.demoplaceholder.model.Image;
import com.example.hiennv.demoplaceholder.model.feed.New;
import com.example.hiennv.demoplaceholder.model.feed.Topic;
import com.example.hiennv.demoplaceholder.model.profile.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    public static String loadJsonFromAsset(Context context, String fileName) throws IOException {
        String json = "";
        AssetManager am = context.getAssets();
        InputStream is = am.open(fileName);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        json = new String(buffer, "UTF-8");

        return json;
    }

    //Load list mage
    public static List<Image> loadListImage(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Image> images = new ArrayList<>();
            JSONArray arrayImage = new JSONArray(loadJsonFromAsset(context, "images.json"));
            for (int i = 0; i < arrayImage.length(); i++) {
                Image image = gson.fromJson(arrayImage.getString(i), Image.class);
                images.add(image);
            }
            return images;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Load danh sach new
    public static List<Topic> loadTopic(Context context) {
        try {
            List<Topic> topics = new ArrayList<>();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray arrayTopic = new JSONArray(loadJsonFromAsset(context, "news.json"));
            for (int i = 0; i < arrayTopic.length(); i++) {
                Topic topic = gson.fromJson(arrayTopic.getString(i), Topic.class);
                topics.add(topic);
            }
            return topics;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Load Infinite
    public static List<New> loadInfiniteNew(Context context) {
        try {
            List<New> news = new ArrayList<>();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray arrayNew = new JSONArray(loadJsonFromAsset(context, "infinite_news.json"));
            for (int i = 0; i < arrayNew.length(); i++) {
                New objNew = gson.fromJson(arrayNew.getString(i), New.class);
                news.add(objNew);
            }
            return news;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Load profile
    public static List<Profile> loadProfiles(Context context) {
        try {
            List<Profile> profiles = new ArrayList<>();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray arrayProfile = new JSONArray(loadJsonFromAsset(context,"profiles.json"));
            for (int i = 0; i < arrayProfile.length(); i++) {
                Profile profile = gson.fromJson(arrayProfile.getString(i),Profile.class);
                profiles.add(profile);
            }
            return profiles;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Resize
    public static Point getDisplaySize(WindowManager windowManager){
        if (Build.VERSION.SDK_INT > 16){
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            return new Point(displayMetrics.widthPixels,displayMetrics.heightPixels);
        }else {
            return new Point(0,0);
        }
    }

    //Chuyen dp -> px
    public static int dpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
