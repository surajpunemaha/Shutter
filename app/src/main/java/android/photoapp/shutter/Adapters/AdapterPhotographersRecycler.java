package android.photoapp.shutter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.photoapp.shutter.Models.Photographer;
import android.photoapp.shutter.ProfileActivity;
import android.photoapp.shutter.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPhotographersRecycler extends RecyclerView.Adapter<AdapterPhotographersRecycler.MyViewHolder>
{
    public Context context;
    public ArrayList<Photographer> al_photographers;

    public AdapterPhotographersRecycler(Context context, ArrayList<Photographer> al_photographers)
    {
        this.context = context;
        this.al_photographers = al_photographers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photographer, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(context, ProfileActivity.class);
                context.startActivity(profile);
            }
        });
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.txtv_name.setText(al_photographers.get(position).getP_name());
        Picasso.with(context).load(al_photographers.get(position).getP_url()).placeholder(R.mipmap.alpha_j).into(holder.imgv_profilePic);
    }

    @Override
    public int getItemCount()
    {
        return al_photographers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtv_name;
        public ImageView imgv_profilePic;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            txtv_name = (TextView) itemView.findViewById(R.id.txtv_name);
            imgv_profilePic = (ImageView) itemView.findViewById(R.id.imgv_profilePic);
        }
    }
}