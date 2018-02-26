package android.photoapp.shutter;

import android.photoapp.shutter.Adapters.AdapterHomePager;
import android.photoapp.shutter.Adapters.AdapterOffersRecycler;
import android.photoapp.shutter.Models.Offer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity
{
    ViewPager viewpgr_home;
    CircleIndicator indicator;
    ArrayList<Integer> al_images;
    RecyclerView recv_offers;

    ArrayList<Offer> al_offer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpUi();

        setUpViewPager();
        getOfferDetails();
        setUpOffersRecycler();
    }

    public void setUpUi()
    {
        viewpgr_home = (ViewPager) findViewById(R.id.viewpgr_home);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        al_images = new ArrayList<>();

        recv_offers = (RecyclerView) findViewById(R.id.recv_offers);
        al_offer = new ArrayList<>();
    }

    public void getOfferDetails()
    {
        Offer o1 = new Offer("1","20%","offer 1", "20 March", "P1");
        Offer o2 = new Offer("2","10%","offer 2", "23 March", "P2");
        Offer o3 = new Offer("3","10%","offer 3", "27 March", "P3");
        al_offer.add(o1);
        al_offer.add(o2);
        al_offer.add(o3);
    }

    public void setUpViewPager()
    {
        al_images.add(R.drawable.shutter_logo_dark_text);
        al_images.add(R.drawable.shutter_logo_dark_text);
        al_images.add(R.drawable.shutter_logo_dark_text);
        al_images.add(R.drawable.shutter_logo_dark_text);

        viewpgr_home.setAdapter(new AdapterHomePager(HomeActivity.this, al_images));
        indicator.setViewPager(viewpgr_home);
    }

    public void setUpOffersRecycler()
    {
        AdapterOffersRecycler adapterOffers = new AdapterOffersRecycler(HomeActivity.this, al_offer);
        recv_offers.setAdapter(adapterOffers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recv_offers.setLayoutManager(mLayoutManager);
        recv_offers.setItemAnimator(new DefaultItemAnimator());
    }
}