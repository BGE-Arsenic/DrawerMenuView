package com.example.apple.drawermenuview;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by apple on 2017/8/7.
 */

public abstract class BaseActivity extends AppCompatActivity{
    /**
     * 获取布局id
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
