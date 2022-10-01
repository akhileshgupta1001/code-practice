import Observable.IphoneObservableImpl;
import Observable.StockObservable;
import Observer.EmailAlertObserverImpl;
import Observer.MobileAlertObserverImpl;
import Observer.NotificationAlertObserver;

public class Stock {

    public static void main(String[] args) {
        StockObservable stockObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new MobileAlertObserverImpl("9911907279",stockObservable);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl("7275803190",stockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("akhilesh.gupta10@Gmail.com",stockObservable);
        NotificationAlertObserver observer4 = new EmailAlertObserverImpl("akhi9722@gmail.com",stockObservable);

        stockObservable.add(observer1);
        stockObservable.add(observer2);
        stockObservable.add(observer3);
        stockObservable.add(observer4);
        stockObservable.setStockCount(1);

    }
}
