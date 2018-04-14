package android.photoapp.shutter;

import android.photoapp.shutter.Adapters.AdapterHomePager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class SlideShowActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener
{
    ImageView imgv_leftArrow, imgv_rightArrow, imgv_back;
    ViewPager vpager_images;
    ArrayList<String> al_images;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        setupUi();

        setupViewPager();
    }

    public void setupUi()
    {
        vpager_images = (ViewPager) findViewById(R.id.vpager_images);

        imgv_leftArrow = (ImageView) findViewById(R.id.imgv_leftArrow);
        imgv_leftArrow.setOnClickListener(this);
        imgv_rightArrow = (ImageView) findViewById(R.id.imgv_rightArrow);
        imgv_rightArrow.setOnClickListener(this);
        imgv_back = (ImageView) findViewById(R.id.imgv_back);
        imgv_back.setOnClickListener(this);

        al_images = new ArrayList<>();
    }

    public void setupViewPager()
    {
        al_images.add("http://surajbang.esy.es/shutter/slider_images/banner_sport.png");
        al_images.add("http://surajbang.esy.es/shutter/slider_images/banner_food.png");
        al_images.add("http://surajbang.esy.es/shutter/slider_images/banner_wedding.png");
        al_images.add("http://surajbang.esy.es/shutter/slider_images/shutter_banner.png");

        vpager_images.setAdapter(new AdapterHomePager(SlideShowActivity.this, al_images));
        vpager_images.setCurrentItem(0);
        vpager_images.setOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.imgv_rightArrow)
        {
            int pos = vpager_images.getCurrentItem();
            if(pos!=al_images.size()) {
                vpager_images.setCurrentItem(pos+1);
            }
        }
        if(v.getId()==R.id.imgv_leftArrow)
        {
            int pos = vpager_images.getCurrentItem();
            if(pos!=0) {
                vpager_images.setCurrentItem(pos-1);
            }
        }
        if(v.getId()==R.id.imgv_back)
        {
            onBackPressed();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(position==0)
        {
            imgv_leftArrow.setVisibility(View.INVISIBLE);
            imgv_rightArrow.setVisibility(View.VISIBLE);

        }
        if(position==1 || position == al_images.size()-2)
        {
            imgv_rightArrow.setVisibility(View.VISIBLE);
            imgv_leftArrow.setVisibility(View.VISIBLE);
        }

        if(position==al_images.size()-1)
        {
            imgv_rightArrow.setVisibility(View.INVISIBLE);
            imgv_leftArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}