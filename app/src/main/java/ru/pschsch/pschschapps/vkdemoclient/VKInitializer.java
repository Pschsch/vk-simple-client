package ru.pschsch.pschschapps.vkdemoclient;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.vk.sdk.*;

public class VKInitializer extends Application {
    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(VKInitializer.this, "-", Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
        Log.d("Инициализация","Успешно!");
    }
}
