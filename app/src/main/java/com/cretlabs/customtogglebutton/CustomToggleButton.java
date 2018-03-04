package com.cretlabs.customtogglebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;



/**
 * Created by Gokul on 3/1/2018.
 * CustomToggleButton
 */

public class CustomToggleButton extends ToggleButton implements View.OnClickListener {
    private static final String TAG = "CustomToggleButton";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            initAttributes(context, attrs);
        }
    }

    public CustomToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            initAttributes(context, attrs);
        }
    }

    public CustomToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            initAttributes(context, attrs);
        }
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributeArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToggleButton);
            Drawable drawableLeft = null;
            Drawable drawableRight = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft = attributeArray.getDrawable(R.styleable.CustomToggleButton_ct_draw_left);
                drawableRight = attributeArray.getDrawable(R.styleable.CustomToggleButton_ct_draw_right);
                drawableBottom = attributeArray.getDrawable(R.styleable.CustomToggleButton_ct_draw_bottom);
                drawableTop = attributeArray.getDrawable(R.styleable.CustomToggleButton_ct_draw_top);
            } else {
                final int drawableLeftId = attributeArray.getResourceId(R.styleable.CustomToggleButton_ct_draw_left, -1);
                final int drawableRightId = attributeArray.getResourceId(R.styleable.CustomToggleButton_ct_draw_right, -1);
                final int drawableBottomId = attributeArray.getResourceId(R.styleable.CustomToggleButton_ct_draw_bottom, -1);
                final int drawableTopId = attributeArray.getResourceId(R.styleable.CustomToggleButton_ct_draw_top, -1);
                if (drawableLeftId != -1)
                    drawableLeft = AppCompatResources.getDrawable(getContext(), drawableLeftId);
                if (drawableRightId != -1)
                    drawableRight = AppCompatResources.getDrawable(getContext(), drawableRightId);
                if (drawableBottomId != -1)
                    drawableBottom = AppCompatResources.getDrawable(getContext(), drawableBottomId);
                if (drawableTopId != -1)
                    drawableTop = AppCompatResources.getDrawable(getContext(), drawableTopId);
            }
            String fontName = attributeArray.getString(R.styleable.CustomToggleButton_ct_fontName);
            if (fontName != null) {
                Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                if (typeface != null) {
                    setTypeface(typeface);
                }
            }
            setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
            attributeArray.recycle();
        }
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick() called with: view = [" + view + "]");
    }
}
