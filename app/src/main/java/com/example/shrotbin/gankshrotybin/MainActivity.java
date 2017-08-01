package com.example.shrotbin.gankshrotybin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.shrotbin.gankshrotybin.base.RxSchedulers;
import com.example.shrotbin.gankshrotybin.bean.HeaderImage;
import com.example.shrotbin.gankshrotybin.bean.VideoBean;
import com.example.shrotbin.gankshrotybin.net.RetrofitFactory;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private TabLayout mTabLayout;
    private CommonAdapter<HeaderImage.ResultsBean> mCommonAdapter;
    private List<HeaderImage.ResultsBean> mResultsBean = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] stringArray = getResources().getStringArray(R.array.tablist);
        mRecyclerView = (RecyclerView) findViewById(R.id.header_iamge_recycler);
        mTabLayout = (TabLayout) findViewById(R.id.main_tab);
        for (int i = 0; i < stringArray.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(stringArray[i]));
        }

        mCommonAdapter = new CommonAdapter<HeaderImage.ResultsBean>(this, R.layout.item_header_iamge, mResultsBean) {
            @Override
            protected void convert(ViewHolder holder, HeaderImage.ResultsBean resultsBean, int position) {
                ImageView imageView = holder.getView(R.id.header_iamge);
                Glide.with(MainActivity.this).load(resultsBean.getUrl()).into(imageView);
                holder.setText(R.id.header_desc, resultsBean.getDesc());
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCommonAdapter);

        Observable.zip(RetrofitFactory.getInstence().getGankApi().getHeaderImage(1),
                RetrofitFactory.getInstence().getGankApi().getVideo(10), new BiFunction<HeaderImage, VideoBean, HeaderImage>() {
                    @Override
                    public HeaderImage apply(@NonNull HeaderImage headerImage, @NonNull VideoBean videoBean) throws Exception {
                        for (int i = 0; i < headerImage.getResults().size(); i++) {
                            String desc = headerImage.getResults().get(i).getDesc() + " " + videoBean.getResults().get(i).getDesc();
                            headerImage.getResults().get(i).setDesc(desc);
                        }
                        return headerImage;
                    }
                }).compose(RxSchedulers.<HeaderImage>compose())
                .subscribe(new Consumer<HeaderImage>() {
                    @Override
                    public void accept(HeaderImage headerImageBaseEntity) throws Exception {
                        mResultsBean.clear();
                        mResultsBean.addAll(headerImageBaseEntity.getResults());
                        mCommonAdapter.notifyDataSetChanged();
                    }
                });
    }
}
