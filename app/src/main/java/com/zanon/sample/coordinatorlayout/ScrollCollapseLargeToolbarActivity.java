package com.zanon.sample.coordinatorlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.zanon.coordinatorlayout.R;

/**
 * Created by romain on 15/10/15.
 */
public class ScrollCollapseLargeToolbarActivity extends AppCompatActivity {

    private View mFab;
    private int mFabTranslationSize = 0;
    private boolean mFabIsVisible = true;

    public static void start(Context context) {
        Intent intent = new Intent(context, ScrollCollapseLargeToolbarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_collapse_large_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String toolbarTitle = getResources().getString(R.string.sample_collapse_scroll_toolbar);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(toolbarTitle);

        mFab = findViewById(R.id.fab);

        NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.nested_scrollview);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    animateFab(false);
                } else {
                    animateFab(true);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void animateFab(boolean show) {
        if (show && !mFabIsVisible) {
            //Show
            mFabIsVisible = true;
            mFab.animate().translationY(0);
        } else if (!show && mFabIsVisible) {
            //Hide
            mFabIsVisible = false;
            if (mFabTranslationSize == 0) {
                int margin = ((CoordinatorLayout.LayoutParams) mFab.getLayoutParams()).bottomMargin;
                mFabTranslationSize = mFab.getHeight() + margin * 2;
            }
            mFab.animate().translationY(mFabTranslationSize);
        }
    }
}
