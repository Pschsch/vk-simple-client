package ru.pschsch.pschschapps.vkdemoclient;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.vk.sdk.*;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.util.VKUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VKDemoBaseActivity extends AppCompatActivity {

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button3:
                    VKSdk.login(VKDemoBaseActivity.this, VKScope.FRIENDS);
                case R.id.button4:
                    final ListView lv = findViewById(R.id.listView);
                    VKRequest vkr = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS,"first_name", "last_name"));
                    vkr.executeWithListener(new VKRequest.VKRequestListener() {
                        @Override
                        public void onComplete(VKResponse response) {
                            super.onComplete(response);
                            VKList list = (VKList)response.parsedModel;
                            ArrayAdapter<String> ad = new ArrayAdapter<>(VKDemoBaseActivity.this, R.layout.tvres, list);
                            lv.setAdapter(ad);
                        }
                    });
        }
    }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThemeChanger.onActivitySetTheme(this);
        setContentView(R.layout.activity_vkdemo_base);
        Toolbar mToolbar = findViewById(R.id.VKDemoToolbar);
        setSupportActionBar(mToolbar);
        /*String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.d("key",Arrays.asList(fingerprints).toString());*/
        Button mAuthButton = findViewById(R.id.button3);
        Button mFriendsList = findViewById(R.id.button4);
        mAuthButton.setOnClickListener(listener);
        mFriendsList.setOnClickListener(listener);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vkdemomenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.blue_theme:
                ActivityThemeChanger.onChangeBaseTheme(this, 1);
                break;
            case R.id.red_theme:
                ActivityThemeChanger.onChangeBaseTheme(this, 2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast.makeText(VKDemoBaseActivity.this, "+", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(VKError error) {
                Toast.makeText(VKDemoBaseActivity.this, "-", Toast.LENGTH_SHORT).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
