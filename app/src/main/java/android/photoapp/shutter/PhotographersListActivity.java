package android.photoapp.shutter;

import android.photoapp.shutter.Adapters.AdapterPhotographersRecycler;
import android.photoapp.shutter.Models.Photographer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class PhotographersListActivity extends AppCompatActivity
{
    ActionBar actionBar;
    RecyclerView recv_photographer;
    ArrayList<Photographer> al_photographers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographers_list);
        setupUI();
        getPhotographersList();
        setPhotographersList();
    }

    public void setupUI()
    {
        actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle(getResources().getString(R.string.photographers));

        recv_photographer = (RecyclerView) findViewById(R.id.recv_photographer);
        al_photographers = new ArrayList<>();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home :
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getPhotographersList()
    {
        Photographer p1 = new Photographer("1", "Suraj Media's","https://www.fchtexas.com/wp-content/uploads/2017/03/Photography.jpg");
        Photographer p2 = new Photographer("2", "Square Space","https://static1.squarespace.com/static/57977ed703596efb1100196c/t/57a0d63d579fb38575c37a35/1470158419376/");
        Photographer p3 = new Photographer("3", "Photo Maniac","http://hgopi.github.io/home/portfolios/Fotomaniac/images/photographer1.jpg");
        Photographer p4 = new Photographer("4", "Modern Lens","http://modernlensmagazine.com/wp-content/uploads/2016/08/promistakes.jpg");
        Photographer p5 = new Photographer("5", "Sara's Official","https://www.nyip.edu/images/cms/photo-articles/how-much-money-do-photographers-make.jpg");

        al_photographers.add(p1); al_photographers.add(p2); al_photographers.add(p3); al_photographers.add(p4);
        al_photographers.add(p5);
    }

    public void setPhotographersList()
    {
        AdapterPhotographersRecycler adapterPhotographers = new AdapterPhotographersRecycler(PhotographersListActivity.this,al_photographers);
        recv_photographer.setAdapter(adapterPhotographers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(PhotographersListActivity.this, LinearLayoutManager.VERTICAL, false);
        recv_photographer.setLayoutManager(mLayoutManager);
        recv_photographer.setItemAnimator(new DefaultItemAnimator());
    }
}
