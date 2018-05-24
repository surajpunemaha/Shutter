package android.photoapp.shutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity
{
    TextView txtv_appName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txtv_appName = (TextView) findViewById(R.id.txtv_appName);


        TranslateAnimation animation = new TranslateAnimation(30,0,0,0);
        animation.setDuration(1000);
        txtv_appName.startAnimation(animation);

        final Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                    //finish();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
