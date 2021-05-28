package com.example.shop.model;


import com.example.shop.notification.Observer;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@ToString
public class Product implements Observable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imgUrl;
    private String name;
    private String description;
    private int inStock;
    private BigDecimal price;

    @Transient
    private Set<Observer> registeredObservers = new HashSet<Observer>();

    @ManyToOne(cascade = {CascadeType.MERGE})
    private ProductCart productCart;

    @Override
    public void registerObserver(Observer observer) {
        registeredObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        registeredObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : registeredObservers) {
            observer.update(this);
        }
    }
}
