package Observer;

import Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    private String mobile;
    private StockObservable stockObservable;

    public MobileAlertObserverImpl(String mobile, StockObservable stockObservable){
        this.mobile= mobile;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMobileAlert(mobile,"Product is in stock hurry up...");
    }

    private void sendMobileAlert(String mobile, String message){
        System.out.println("Message send to : "+mobile+" , "+message);
    }
}
