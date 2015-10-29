package com.zanon.sample.coordinatorlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zanon.coordinatorlayout.R;

/**
 * Created by romain on 15/10/15.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.large_toolbar_fix).setOnClickListener(this);
        findViewById(R.id.scroll_toolbar).setOnClickListener(this);
        findViewById(R.id.collapse_large_toolbar).setOnClickListener(this);
        findViewById(R.id.scroll_collapse_large_toolbar).setOnClickListener(this);
        findViewById(R.id.parallax_image_toolbar).setOnClickListener(this);
        findViewById(R.id.custom_behavior).setOnClickListener(this);
        findViewById(R.id.snackbar).setOnClickListener(this);
        findViewById(R.id.pager_tabs).setOnClickListener(this);
        findViewById(R.id.pager_tabs_fixed_image).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.large_toolbar_fix:
                LargeToolbarFixActivity.start(this);
                break;
            case R.id.scroll_toolbar:
                ScrollToolbarActivity.start(this);
                break;
            case R.id.collapse_large_toolbar:
                CollapseLargeToolbarActivity.start(this);
                break;
            case R.id.scroll_collapse_large_toolbar:
                ScrollCollapseLargeToolbarActivity.start(this);
                break;
            case R.id.parallax_image_toolbar:
                ParallaxImageToolbarActivity.start(this);
                break;
            case R.id.custom_behavior:
                CustomBehaviorActivity.start(this);
                break;
            case R.id.snackbar:
                SnackbarActivity.start(this);
                break;
            case R.id.pager_tabs:
                PagerTabsActivity.start(this);
                break;
            case R.id.pager_tabs_fixed_image:
                PagerTabsParallaxImageActivity.start(this);
                break;
            default:
                break;
        }
    }
}
