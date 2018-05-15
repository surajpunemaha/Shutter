package android.photoapp.shutter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.photoapp.shutter.Adapters.AdapterCommentsRecycler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileActivity extends Activity implements View.OnClickListener {

    FloatingActionButton fab_slideshow;
    RecyclerView recv_comments;
    ImageView imgv_profilePic , imgv_addReview;
    CollapsingToolbarLayout collapsing_toolbar;
    AlertDialog review_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupUI();
    }

    public void setupUI()
    {
        collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("ABC PQR");
        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        imgv_profilePic = (ImageView) findViewById(R.id.imgv_profilePic);
        imgv_addReview = (ImageView) findViewById(R.id.imgv_addReview);
        imgv_addReview.setOnClickListener(this);

        Picasso.with(ProfileActivity.this).load("https://static1.squarespace.com/static/57977ed703596efb1100196c/t/57a0d63d579fb38575c37a35/1470158419376/")
                .into(imgv_profilePic);

        recv_comments = (RecyclerView) findViewById(R.id.recv_comments);

        ArrayList<String> al_comments = new ArrayList<String>();
        al_comments.add("This is comment one");
        al_comments.add("This is comment two");
        al_comments.add("This is comment three");
        al_comments.add("This is comment four");
        al_comments.add("This photographer is very nice. They took nice pictures of my family. We are very happy with servvice.");
        al_comments.add("This is comment six\n and multiline comment\nThanks....");
        al_comments.add("This is comment seven\t this is multiline");
        al_comments.add("This is comment eight");
        al_comments.add("This is comment nine");
        al_comments.add("This is comment ten\t this is multiline");
        al_comments.add("This is comment eleven");
        al_comments.add("This is comment twelve");
        al_comments.add("This is comment thirteen");
        al_comments.add("This is comment fourteen\t this is multiline");

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
        if(v.getId()==R.id.imgv_addReview)
        {
            View review = getLayoutInflater().inflate(R.layout.add_review,null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(review);
            SpannableString title = new SpannableString(getResources().getString(R.string.addReview));
            title.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_green)), 0, title.length(), 0);
            builder.setTitle(title);
            builder.setPositiveButton(getResources().getString(R.string.okay), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    review_dialog.dismiss();
                }
            });
            review_dialog = builder.create();
            review_dialog.show();
        }
    }
}