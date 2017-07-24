package com.example.shrotbin.gankshrotybin;

import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CommonAdapter<HeaderImage.ResultsBean> mCommonAdapter;
    private List<HeaderImage.ResultsBean> mResultsBean = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.header_iamge_recycler);
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
        Call<HeaderImage> headerImage = retrofitFactory.getGankApi().getHeaderImage(1);
        headerImage.enqueue(new Callback<HeaderImage>() {
            @Override
            public void onResponse(Call<HeaderImage> call, Response<HeaderImage> response) {
                HeaderImage body = response.body();
                mResultsBean.clear();
                mResultsBean.addAll(body.getResults());
                mCommonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<HeaderImage> call, Throwable t) {

            }
        });

    }
}
