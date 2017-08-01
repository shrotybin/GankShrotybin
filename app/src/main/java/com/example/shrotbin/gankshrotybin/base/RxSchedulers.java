package com.example.shrotbin.gankshrotybin.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/08/01
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                //此处添加是否有网络
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
