package zhy.com.rxjava.bus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {

    public RxBus() {
    }

    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public <T extends Object> Observable<T> toObserverable(final Class<T> eventType) {
        return _bus.ofType(eventType);
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }
}