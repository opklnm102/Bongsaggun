package io.j2ffrey_2.bongsaggun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by andasom on 2015-10-29.
 */
public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    // Animation
    Animation bongAni, saAni, ggunAni;

    ImageView bong, sa, ggun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        bong = (ImageView)findViewById(R.id.bong);
        sa = (ImageView)findViewById(R.id.sa);
        ggun = (ImageView)findViewById(R.id.ggun);


        //애니메이션 등록
        bongAni = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.bong_ani);
        saAni = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.sa_ani);
        ggunAni = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.ggun_ani);

        //애니메이션 시작
        bong.startAnimation(bongAni);
        sa.startAnimation(saAni);
        ggun.startAnimation(ggunAni);



        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);


                finish();
                //overridePendingTransition(R.anim.move, R.anim.alpha); 스플래시 자체가서서히 사라지게 하고 싶을때


            }
        }, SPLASH_TIME_OUT);
    }


}




