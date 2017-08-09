package com.example.apple.drawermenuview;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by apple on 2017/8/7.
 */

public abstract class BaseActivity extends AppCompatActivity{

    private CompositeSubscription mCompositeSubscription;

    /**
     * 获取布局id
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 在 super.onCreate(savedInstanceState) 之前调用该方法
//        initSwipeBackFinish();
        super.onCreate(savedInstanceState);
        beforeInit();
        if(getContentViewLayoutID() != 0){
            setContentView(getContentViewLayoutID());
            initView(savedInstanceState);
        }
    }

    /**
     * 界面初始化前期准备
     */
    protected void beforeInit() {

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public CompositeSubscription getCompositeSubscription(){
        checkSubscription();
        return this.mCompositeSubscription;
    }

    /**
     *避免空指针的情况
     */
    private void checkSubscription(){
        if (this.mCompositeSubscription == null){
            this.mCompositeSubscription = new CompositeSubscription();
        }
    }

    /**
     * 增加一个调度器
     */
    protected void addSubscription(Subscription s){
        checkSubscription();
        this.mCompositeSubscription.add(s);
    }
}
