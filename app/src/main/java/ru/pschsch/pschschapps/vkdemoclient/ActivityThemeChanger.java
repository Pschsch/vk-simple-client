package ru.pschsch.pschschapps.vkdemoclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

class ActivityThemeChanger {
    private static int mTheme;
    private static final int BLUE_THEME = 1;
    private static final int RED_THEME = 2;
    static void onChangeBaseTheme(AppCompatActivity activity, int theme){
        mTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    static void onActivitySetTheme(AppCompatActivity activity){
        switch(mTheme){
            case BLUE_THEME:
                activity.setTheme(R.style.BaseTheme);
                break;
            case RED_THEME:
                activity.setTheme(R.style.Darkbasetheme);
                break;
        }
    }
}
