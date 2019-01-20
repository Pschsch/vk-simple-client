package ru.pschsch.pschschapps.vkdemoclient;
/*Для анимирования пользуемся Transition API*/
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;


public class SplashScreen extends AppCompatActivity {

    public final int SPLASH_DUR = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashroot);
      /*  ViewGroup root = findViewById(R.id.sceneRoot);
        Scene sc1 = Scene.getSceneForLayout(root, R.id.emptyscene, this);
        Scene sc2 = Scene.getSceneForLayout(root, R.id.fillscene, this);
        TransitionManager.go(sc2);*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, VKDemoBaseActivity.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DUR);
    }
}
