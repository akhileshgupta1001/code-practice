package ObserverDP.Observable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements Observable.StockObservable {

    List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount =0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
    observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
      for(NotificationAlertObserver alertObserver : observerList){
          alertObserver.update();
      }
    }

    @Override
    public void setStockCount(int newStockCount) {
       if(stockCount==0)
           notifySubscribers();
       stockCount = stockCount+newStockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
