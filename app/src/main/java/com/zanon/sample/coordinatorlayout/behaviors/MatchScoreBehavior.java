package com.zanon.sample.coordinatorlayout.behaviors;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.zanon.coordinatorlayout.R;

/**
 * Created by romain on 26/10/15.
 */
public class MatchScoreBehavior extends CoordinatorLayout.Behavior<TextView> {

    private static final float TOOLBAR_SCALE = 0.7f;

    private final Context mContext;
    private int mToolbarHeight;
    private int mMaxScrollAppBar;
    private float mTextSizeMax;

    /**
     * Constructor
     *
     * @param context Context
     * @param attrs   AttributeSet
     */
    public MatchScoreBehavior(Context context, AttributeSet attrs) {
        mContext = context;
        init(context);
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        mTextSizeMax = resources.getDimension(R.dimen.custom_behavior_text_size);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        AppBarLayout appBarLayout = (AppBarLayout) dependency;
        shouldInitProperties(child, appBarLayout);

        int currentScroll = dependency.getBottom();
        float percentage = (float) currentScroll / (float) mMaxScrollAppBar;
        if (percentage < TOOLBAR_SCALE) {
            percentage = TOOLBAR_SCALE;
        }
        child.setScaleY(percentage);
        child.setScaleX(percentage);
        return true;
    }

    private void shouldInitProperties(TextView child, AppBarLayout appBarLayout) {
        if (mMaxScrollAppBar == 0) {
            mMaxScrollAppBar = appBarLayout.getTotalScrollRange();
        }
        if (mToolbarHeight == 0) {
            TypedArray styledAttributes = mContext.getTheme().obtainStyledAttributes(
                    new int[]{android.R.attr.actionBarSize});
            mToolbarHeight = (int) styledAttributes.getDimension(0, 0);
            styledAttributes.recycle();
        }
    }
}
