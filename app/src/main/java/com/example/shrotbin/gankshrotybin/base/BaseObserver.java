package com.example.shrotbin.gankshrotybin.base;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/08/01
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;

    protected BaseObserver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if (value.isSuccess()) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }


    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
