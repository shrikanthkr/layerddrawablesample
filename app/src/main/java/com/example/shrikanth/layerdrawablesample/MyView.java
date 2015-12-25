package com.example.shrikanth.layerdrawablesample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by shrikanth on 12/25/15.
 */
public class MyView extends TextView {
    String distanceExample;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Style, 0, 0);
        try {
            distanceExample = ta.getString(R.styleable.Style_style_id);
            Log.i("VIEW", distanceExample);
            ShapeDrawable border = new ShapeDrawable();
            border.getPaint().setColor(Color.BLUE);

            ShapeDrawable background = new ShapeDrawable();
            background.getPaint().setColor(Color.BLACK);


            ShapeDrawable clip = new ShapeDrawable();
            clip.getPaint().setColor(Color.WHITE);

            Drawable[] layers = {background, border, clip};
            LayerDrawable layerDrawable = new LayerDrawable(layers);

            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            layerDrawable.setLayerInset(1, 1, 0, 1, 1);
            layerDrawable.setLayerInset(2, 0, 0, 0, 2);
            setBackgroundDrawable(layerDrawable);
        } finally {
            ta.recycle();
        }
    }
}
