package android.photoapp.shutter.Adapters;

import android.content.Context;
import android.photoapp.shutter.Models.Offer;
import android.photoapp.shutter.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterOffersRecycler extends RecyclerView.Adapter<AdapterOffersRecycler.MyViewHolder>
{
    public Context context;
    public ArrayList<Offer> al_offer;

    public AdapterOffersRecycler(Context context, ArrayList<Offer> al_offer)
    {
        this.context = context;
        this.al_offer = al_offer;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer_list, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.txtv_offerName.setText(al_offer.get(position).getOffer_name());
        holder.txtv_offerDiscount.setText(al_offer.get(position).getOffer_value());
        Picasso.with(context).load(al_offer.get(position).getPic_url()).placeholder(R.mipmap.alpha_j).into(holder.imgv_offer);
    }

    @Override
    public int getItemCount()
    {
        return al_offer.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtv_offerDiscount, txtv_offerName, txtv_offerValidity, txtv_offerProvider;
        public ImageView imgv_offer;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            imgv_offer = (ImageView) itemView.findViewById(R.id.imgv_offer);
            txtv_offerDiscount = (TextView) itemView.findViewById(R.id.txtv_offerDiscount);
            txtv_offerName = (TextView) itemView.findViewById(R.id.txtv_offerName);
            txtv_offerValidity = (TextView) itemView.findViewById(R.id.txtv_offerValidity);
            txtv_offerProvider = (TextView) itemView.findViewById(R.id.txtv_offerProvider);
        }
    }
}
