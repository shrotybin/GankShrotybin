package com.example.shrotbin.gankshrotybin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.shrotbin.gankshrotybin.bean.HeaderImage;
import com.example.shrotbin.gankshrotybin.net.RetrofitFactory;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TabLayout mTabLayout;
    private CommonAdapter<HeaderImage.ResultsBean> mCommonAdapter;
    private List<HeaderImage.ResultsBean> mResultsBean = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.header_iamge_recycler);
        mTabLayout= (TabLayout) findViewById(R.id.main_tab);
        mTabLayout.addTab(mTabLayout.newTab().setText("Android"));
        mTabLayout.addTab(mTabLayout.newTab().setText("IOS"));

        mCommonAdapter = new CommonAdapter<HeaderImage.ResultsBean>(this, R.layout.item_header_iamge, mResultsBean) {
            @Override
            protected void convert(ViewHolder holder, HeaderImage.ResultsBean resultsBean, int position) {
                ImageView imageView = holder.getView(R.id.header_iamge);
                Glide.with(MainActivity.this).load(resultsBean.getUrl()).into(imageView);
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCommonAdapter);

        RetrofitFactory retrofitFactory = new RetrofitFactory();

        retrofitFactory.getGankApi().getHeaderImage(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HeaderImage>() {
                    @Override
                    public void accept(HeaderImage headerImage) throws Exception {
                        mResultsBean.clear();
                        mResultsBean.addAll(headerImage.getResults());
                        mCommonAdapter.notifyDataSetChanged();
                    }
                });
    }
}
