package android.photoapp.shutter.Adapters;

import android.content.Context;
import android.photoapp.shutter.Models.Categories;
import android.photoapp.shutter.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCategoriesRecycler extends RecyclerView.Adapter<AdapterCategoriesRecycler.MyViewHolder>
{
    public Context context;
    public ArrayList<Categories> al_categories;

    public AdapterCategoriesRecycler(Context context, ArrayList<Categories> al_categories)
    {
        this.context = context;
        this.al_categories = al_categories;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories_list, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.txtv_categoryName.setText(al_categories.get(position).getCategory_name());
        Picasso.with(context).load(al_categories.get(position).getPic_url()).into(holder.imgv_category);
    }

    @Override
    public int getItemCount()
    {
        return al_categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtv_categoryName;
        public ImageView imgv_category;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            txtv_categoryName = (TextView) itemView.findViewById(R.id.txtv_categoryName);
            imgv_category = (ImageView) itemView.findViewById(R.id.imgv_category);
        }
    }
}
