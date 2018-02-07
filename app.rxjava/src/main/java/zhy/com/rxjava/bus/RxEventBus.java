package zhy.com.rxjava.bus;


import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RxEventBus {


    public static final String TAG = "RxBus";
    private RxBus rxBus;
    private CompositeSubscription subscriptions;

    public RxEventBus(RxBus rxBus) {
        this.rxBus = rxBus;
        this.subscriptions = new CompositeSubscription();
    }

    public void post(Object msg) {
        if (rxBus.hasObservers()) {
            rxBus.send(msg);
        }
    }


    public <T> void subscribe(Class<T> dtoType, Action1<T> onSuccess) {
        this.subscribe(dtoType, onSuccess, getDefaultOnError());
    }

    private Action1<Throwable> getDefaultOnError() {
        return throwable -> Log.e(TAG, "rx eventbus post message error.", throwable);
    }

    public <T> void subscribe(Class<T> dtoType, Action1<T> onSuccess, Action1<Throwable> onError) {
        subscriptions.add(rxBus.toObserverable(dtoType)
                .window(5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tObservable -> {

                    Subscription subscription = tObservable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(onSuccess, onError);
                    subscriptions.add(subscription);
                    Log.d(TAG, "subscriptions add ");
                }, getDefaultOnError()));
    }

    public void unsubscribe() {
        subscriptions.unsubscribe();
    }
}
