package Observer;

import Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    private String email;
    private StockObservable stockObservable;


    public EmailAlertObserverImpl(String email, StockObservable stockObservable){
        this.email = email;
        this.stockObservable= stockObservable;
    }

    @Override
    public void update() {
       sendEmail(email,"Product is in stock hurry up...");
    }

    public void sendEmail(String email, String message){
        System.out.println("Mail send to : "+email+" , "+message);
    }
}
