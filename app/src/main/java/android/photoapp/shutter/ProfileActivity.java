package android.photoapp.shutter;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

public class ProfileActivity extends Activity implements View.OnClickListener {

    FloatingActionButton fab_slideshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupUI();
    }

    public void setupUI()
    {
        //fab_slideshow = (FloatingActionButton) findViewById(R.id.fab_slideshow);
        //fab_slideshow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //if(v.getId()==R.id.fab_slideshow)
        //{
        //    startActivity(new Intent(ProfileActivity.this, SlideShowActivity.class));
        //}
    }
}