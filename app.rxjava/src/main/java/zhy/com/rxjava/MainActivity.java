package zhy.com.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import zhy.com.rxjava.bus.RxBus;
import zhy.com.rxjava.bus.RxEventBus;

public class MainActivity extends AppCompatActivity {

    private RxEventBus eventBus;
    private TextView tvTxt;
    private int index;

    Subject<Integer, Integer> subject = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTxt = findViewById(R.id.tv_txt);

        findViewById(R.id.btn_post).setOnClickListener(v -> {
            eventBus.post(new Event("" + index));
            index++;
        });

        eventBus = new RxEventBus(new RxBus());
        eventBus.subscribe(Event.class, this::onEvent);


        findViewById(R.id.btn_win1).setOnClickListener(view -> window()
        );

        subject.window(2)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onCompleted() {
                        log("------>onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        log("------>onError()" + e);
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        log("------->onNext() " + integerObservable);

                        log(integerObservable.toSingle().toBlocking().value());
//                        integerObservable.subscribe(new Action1<Integer>() {
//                            @Override
//                            public void call(Integer integer) {
//                                log("------>call():" + integer);
//                            }
//                        });
                    }
                });

        findViewById(R.id.btn_win2).setOnClickListener(e -> {
                    subject.onNext(index);
                    index++;
                }
        );


        findViewById(R.id.btn_scheduler).setOnClickListener(e -> {
            scheduler1();
        });

    }

    private void log(Object msg) {
        Log.i("TAG", Thread.currentThread().getName() + " " + msg.toString());
    }

    public void window() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(10)
                .window(3)
                .subscribe(new Observer<Observable<Long>>() {
                    @Override
                    public void onCompleted() {
                        log("------>onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        log("------>onError()" + e);
                    }

                    @Override
                    public void onNext(Observable<Long> integerObservable) {
                        log("------->onNext()");
                        integerObservable.subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long integer) {
                                log("------>call():" + integer);
                            }
                        });
                    }
                });


    }

    private void onEvent(Event event) {
        tvTxt.setText(event.getMsg());
    }


    private class Event {
        private String msg;

        public Event(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }


    private Observable<Observable<Long>> wondowTimeObserver() {
        return Observable
                .interval(1, TimeUnit.SECONDS)
                .take(20)
                .window(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread());
    }


    private void scheduler1() {
        Single.create((Single.OnSubscribe<Integer>) singleSubscriber -> {
            for (int i = 0; i < 10; i++) {
                log("send data " + i);
                singleSubscriber.onSuccess(i);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        log("receive data " + integer);
                    }
                })

        ;
    }

}
