package zhy.com.rxjava;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class OpTest {

    @Test
    public void test_subject() {
        Subject<Object, Object> subject = PublishSubject.create();

        subject.subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }
        });

        subject.onNext("1");
        subject.onNext("2");
        subject.onNext("3");
        subject.onNext("4");
    }


    @Test
    public void test_window() throws Exception {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(10)
                .window(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Observable<Long>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("------>onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("------>onError()" + e);
                    }

                    @Override
                    public void onNext(Observable<Long> integerObservable) {
                        System.out.println("------->onNext()");
                        integerObservable.subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long integer) {
                                System.out.println("------>call():" + integer);
                            }
                        });
                    }
                });

    }
}
