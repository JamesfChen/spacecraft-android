package com.hawksjamesf.uicomponent.scrollExprimental;

import android.os.Bundle;

import com.hawksjamesf.uicomponent.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Nov/25/2018  Sun
 */
public class ScrollableActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        RecyclerView.SmoothScroller
//        LinearSmoothScroller
        setContentView(R.layout.activity_scrollable);
    }


}
