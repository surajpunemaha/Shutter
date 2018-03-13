package android.photoapp.shutter.Adapters;

import android.content.Context;
import android.photoapp.shutter.Models.Photographer;
import android.photoapp.shutter.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterMostVisitedRecycler extends RecyclerView.Adapter<AdapterMostVisitedRecycler.MyViewHolder>
{
    public Context context;
    public ArrayList<Photographer> al_photographers;

    public AdapterMostVisitedRecycler(Context context, ArrayList<Photographer> al_photographers)
    {
        this.context = context;
        this.al_photographers = al_photographers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_most_visited, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.txtv_name.setText(al_photographers.get(position).getP_name());
    }

    @Override
    public int getItemCount()
    {
        return al_photographers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtv_name;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            txtv_name = (TextView) itemView.findViewById(R.id.txtv_name);
        }
    }
}