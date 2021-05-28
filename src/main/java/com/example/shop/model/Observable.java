package com.example.shop.model;

import com.example.shop.notification.Observer;
import org.springframework.stereotype.Component;

@Component
public interface Observable {

    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}
