package android.photoapp.shutter.Custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class TitleTextView extends android.support.v7.widget.AppCompatTextView
{
    public TitleTextView(Context context)
    {
        super(context);
        applyCustomFont(context);
    }

    public TitleTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        applyCustomFont(context);
    }

    public TitleTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        applyCustomFont(context);
    }

    @Override
    public void setTextAppearance(Context context, int resId)
    {
        //super.setTextAppearance(context, resId);

        //super.setTextAppearance(android.R.style.TextAppearance_Large);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            super.setTextAppearance(context, android.R.style.TextAppearance_Large);
        } else {
            super.setTextAppearance(android.R.style.TextAppearance_Large);
        }
    }


    /* @Override
    public void setTextAppearance(Context context, int resId)
    {
    }*/

    @Override
    public void setTextColor(int color)
    {
        super.setTextColor(color);
        setColor(getContext());
    }
    /* @Override
    public void setTextAppearance(int resId)
    {
        super.setTextAppearance(resId);
    }

    @Override
    public void setTypeface(Typeface tf, int style)
    {
        super.setTypeface(tf, Typeface.ITALIC);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }*/

    private void applyCustomFont(Context context)
    {
        Typeface customFont = FontCache.getTypeface("forte.ttf", context);
        setTypeface(customFont);
    }


    private void setColor(Context context)
    {
        setTextColor(Color.RED);
    }
}
