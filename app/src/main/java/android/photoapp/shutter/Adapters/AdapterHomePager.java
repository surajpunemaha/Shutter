package android.photoapp.shutter.Adapters;

import android.content.Context;
import android.photoapp.shutter.R;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterHomePager extends android.support.v4.view.PagerAdapter
{
    private ArrayList<String> images_url;
    private LayoutInflater inflater;
    private Context context;

    public AdapterHomePager(Context context, ArrayList<String> images_url)
    {
        this.context = context;
        this.images_url=images_url;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);
    }

    @Override
    public int getCount()
    {
        return images_url.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position)
    {
        View myImageLayout = inflater.inflate(R.layout.slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);

        Picasso.with(context).load(images_url.get(position)).into(myImage);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view.equals(object);
    }
}
