package android.photoapp.shutter.Adapters;

import android.content.Context;
import android.photoapp.shutter.Models.Offer;
import android.photoapp.shutter.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterCommentsRecycler extends RecyclerView.Adapter<AdapterCommentsRecycler.MyViewHolder>
{
    public Context context;
    public ArrayList<String> al_comments;

    public AdapterCommentsRecycler(Context context, ArrayList<String> al_comments)
    {
        //Toast.makeText(context, "constructor", Toast.LENGTH_SHORT).show();
        this.context = context;
        this.al_comments = al_comments;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //Toast.makeText(context, "on create view holder", Toast.LENGTH_SHORT).show();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comments, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        if(position%2==0)
        {
            holder.layout_comment.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

        holder.txtv_commentText.setText(""+al_comments.get(position));
        //Toast.makeText(context, "on bind view holder", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount()
    {
        //Toast.makeText(context, "returning count", Toast.LENGTH_SHORT).show();
        return al_comments.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtv_commentText;
        public LinearLayout layout_comment;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            txtv_commentText = (TextView) itemView.findViewById(R.id.txtv_commentText);
            layout_comment = (LinearLayout) itemView.findViewById(R.id.layout_comment);
        }
    }
}