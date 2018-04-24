package android.photoapp.shutter;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.photoapp.shutter.Adapters.AdapterCommentsRecycler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ProfileActivity extends Activity implements View.OnClickListener {

    FloatingActionButton fab_slideshow;
    RecyclerView recv_comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupUI();
    }

    public void setupUI()
    {
        recv_comments = (RecyclerView) findViewById(R.id.recv_comments);

        ArrayList<String> al_comments = new ArrayList<String>();
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");
        al_comments.add("This is comment one ");

        AdapterCommentsRecycler adapter = new AdapterCommentsRecycler(ProfileActivity.this, al_comments);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recv_comments.setLayoutManager(mLayoutManager);
        recv_comments.setAdapter(adapter);

        fab_slideshow = (FloatingActionButton) findViewById(R.id.fab_slideshow);
        fab_slideshow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.fab_slideshow)
        {
            startActivity(new Intent(ProfileActivity.this, SlideShowActivity.class));
        }
    }
}