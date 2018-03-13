package android.photoapp.shutter;

import android.photoapp.shutter.Adapters.AdapterCategoriesRecycler;
import android.photoapp.shutter.Adapters.AdapterHomePager;
import android.photoapp.shutter.Adapters.AdapterMostVisitedRecycler;
import android.photoapp.shutter.Adapters.AdapterOffersRecycler;
import android.photoapp.shutter.Models.Categories;
import android.photoapp.shutter.Models.Offer;
import android.photoapp.shutter.Models.Photographer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity
{
    ViewPager viewpgr_home;
    CircleIndicator indicator;
    ArrayList<String> al_images;
    RecyclerView recv_offers, recv_mostVisited, recv_categories;

    ArrayList<Offer> al_offer;
    ArrayList<Photographer> al_mostvisited;
    ArrayList<Categories> al_categories;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpUi();

        setUpViewPager();

        getOfferDetails();
        setUpOffersRecycler();

        getMostVisitedProfiles();
        setUpMostVisitedRecycler();

        getCategories();
        setUpCategoriesRecycler();
    }

    public void setUpUi()
    {
        viewpgr_home = (ViewPager) findViewById(R.id.viewpgr_home);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        al_images = new ArrayList<>();

        recv_offers = (RecyclerView) findViewById(R.id.recv_offers);
        al_offer = new ArrayList<>();

        recv_mostVisited = (RecyclerView) findViewById(R.id.recv_mostVisited);
        al_mostvisited = new ArrayList<>();

        recv_categories = (RecyclerView) findViewById(R.id.recv_categories);
        al_categories = new ArrayList<>();
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

    public void getMostVisitedProfiles()
    {
        Photographer p1 = new Photographer("1", "Suraj");
        Photographer p2 = new Photographer("2", "Tushar");
        Photographer p3 = new Photographer("3", "Pankaj");
        Photographer p4 = new Photographer("4", "Swapnil");

        al_mostvisited.add(p1); al_mostvisited.add(p2); al_mostvisited.add(p3); al_mostvisited.add(p4);
    }

    public void getCategories()
    {
        Categories c1 = new Categories("1", "WildLife","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR560orWmON0npB18Wrl6O0-qZxDGTdNaP9t6DtUUBaLkNRtS1Ajw");
        Categories c2 = new Categories("2", "Wedding","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWcEaLD77zD8P1vjZdVOo3Vfi8xYlT7LKSbfWryk5iIc65hPwH");
        Categories c3 = new Categories("3", "Product","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR560orWmON0npB18Wrl6O0-qZxDGTdNaP9t6DtUUBaLkNRtS1Ajw");
        Categories c4 = new Categories("4", "Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWcEaLD77zD8P1vjZdVOo3Vfi8xYlT7LKSbfWryk5iIc65hPwH");
        Categories c5 = new Categories("5","Event","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWcEaLD77zD8P1vjZdVOo3Vfi8xYlT7LKSbfWryk5iIc65hPwH");

        al_categories.add(c1); al_categories.add(c2); al_categories.add(c3); al_categories.add(c4); al_categories.add(c5);
    }

    public void setUpViewPager()
    {
        al_images.add("http://surajbang.esy.es/shutter/slider_images/banner_sport.png");
        al_images.add("http://surajbang.esy.es/shutter/slider_images/banner_food.png");
        al_images.add("http://surajbang.esy.es/shutter/slider_images/banner_wedding.png");
        al_images.add("http://surajbang.esy.es/shutter/slider_images/shutter_banner.png");

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

    public void setUpMostVisitedRecycler()
    {
        AdapterMostVisitedRecycler adapterMostVisited = new AdapterMostVisitedRecycler(HomeActivity.this,al_mostvisited);
        recv_mostVisited.setAdapter(adapterMostVisited);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recv_mostVisited.setLayoutManager(mLayoutManager);
        recv_mostVisited.setItemAnimator(new DefaultItemAnimator());
    }

    public void setUpCategoriesRecycler()
    {
        AdapterCategoriesRecycler adapterCategories = new AdapterCategoriesRecycler(HomeActivity.this, al_categories);
        recv_categories.setAdapter(adapterCategories);
        recv_categories.hasFixedSize();

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recv_categories.setLayoutManager(mLayoutManager);
        recv_mostVisited.setItemAnimator(new DefaultItemAnimator());
    }
}