package android.photoapp.shutter;

import android.content.Intent;
import android.photoapp.shutter.Adapters.AdapterCategoriesRecycler;
import android.photoapp.shutter.Adapters.AdapterHomePager;
import android.photoapp.shutter.Adapters.AdapterMostVisitedRecycler;
import android.photoapp.shutter.Adapters.AdapterOffersRecycler;
import android.photoapp.shutter.Models.Categories;
import android.photoapp.shutter.Models.Offer;
import android.photoapp.shutter.Models.Photographer;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewpgr_home;
    CircleIndicator indicator;
    ArrayList<String> al_images;
    RecyclerView recv_offers, recv_mostVisited, recv_categories;
    FloatingActionButton fab_options;

    ArrayList<Offer> al_offer;
    ArrayList<Photographer> al_mostvisited;
    ArrayList<Categories> al_categories;

    boolean fabExpanded = false;
    LinearLayout layout_options, layout_helpdesk, layout_about;

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

        fab_options = (FloatingActionButton) findViewById(R.id.fab_options);
        fab_options.setOnClickListener(this);

        layout_options = (LinearLayout) findViewById(R.id.layout_options);
        layout_options.setVisibility(View.GONE);

        layout_helpdesk = (LinearLayout) findViewById(R.id.layout_helpdesk);
        layout_helpdesk.setOnClickListener(this);

        layout_about = (LinearLayout) findViewById(R.id.layout_about);
        layout_about.setOnClickListener(this);


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
        Photographer p1 = new Photographer("1", "Suraj Media's","https://www.fchtexas.com/wp-content/uploads/2017/03/Photography.jpg");
        Photographer p2 = new Photographer("2", "Square Space","https://static1.squarespace.com/static/57977ed703596efb1100196c/t/57a0d63d579fb38575c37a35/1470158419376/");
        Photographer p3 = new Photographer("3", "Photo Maniac","http://hgopi.github.io/home/portfolios/Fotomaniac/images/photographer1.jpg");
        Photographer p4 = new Photographer("4", "Modern Lens","http://modernlensmagazine.com/wp-content/uploads/2016/08/promistakes.jpg");
        Photographer p5 = new Photographer("5", "Sara's Official","https://www.nyip.edu/images/cms/photo-articles/how-much-money-do-photographers-make.jpg");


        al_mostvisited.add(p1); al_mostvisited.add(p2); al_mostvisited.add(p3); al_mostvisited.add(p4);
        al_mostvisited.add(p5);
    }

    public void getCategories()
    {
        Categories c1 = new Categories("1", "WildLife","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR560orWmON0npB18Wrl6O0-qZxDGTdNaP9t6DtUUBaLkNRtS1Ajw");
        Categories c2 = new Categories("2", "Wedding","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWcEaLD77zD8P1vjZdVOo3Vfi8xYlT7LKSbfWryk5iIc65hPwH");
        Categories c3 = new Categories("3","Candid","https://i.guim.co.uk/img/static/sys-images/Arts/Arts_/Pictures/2007/01/23/emmachadwick256.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=1b7d62eb14b387a2d71a9ad0341d78c2");
        Categories c4 = new Categories("4", "Product","http://d1marr3m5x4iac.cloudfront.net/images/block/I0-001/039/906/273-0.jpeg_/iphone-product-photography-heartpreneurs-73.jpeg");
        Categories c5 = new Categories("5", "Food","https://78.media.tumblr.com/avatar_165bc9d68184_128.pnj");
        Categories c6 = new Categories("6","Sports","https://a.rootsandrain.com/f/eindp/20160717-cathkin-braes-country-park/saturday/600_0560_t.jpg");

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

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.fab_options)
        {
            if (fabExpanded)
            {
                closeSubMenusFab();
            }
            else
            {
                openSubMenusFab();
            }
        }
        if(v.getId()==R.id.layout_helpdesk)
        {
            startActivity(new Intent(HomeActivity.this, HelpdeskActivity.class));
        }
        if(v.getId()==R.id.layout_about)
        {
            startActivity(new Intent(HomeActivity.this, PhotographersListActivity.class));
        }
    }

    private void openSubMenusFab()
    {
        layout_options.setVisibility(View.VISIBLE);
        fab_options.setImageResource(R.drawable.ic_close_white_36dp);
        fabExpanded = true;
    }

    private void closeSubMenusFab()
    {
        layout_options.setVisibility(View.GONE);
        fab_options.setImageResource(R.drawable.ic_more_vert_white_24dp);
        fabExpanded = false;
    }
}