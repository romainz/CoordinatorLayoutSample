package com.zanon.sample.coordinatorlayout.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.zanon.coordinatorlayout.R;

/**
 * Created by romain on 28/10/15.
 */
public class ContentView extends FrameLayout {

    public ContentView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_content, this);
    }
}
