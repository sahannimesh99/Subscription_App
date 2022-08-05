package com.sahan;

import com.sahan.observer.SubscriptionObserver;
import com.sahan.observer.SubscriptionObserverImpl;
import com.sahan.view.HomeScreen;

/**
 *
 * @author Sahan Nimesha
 */

public class AppInitializer {
    public static void main(String[] args) {
        SubscriptionObserver observer = new SubscriptionObserverImpl();
        new HomeScreen(observer).setVisible(true);
    }
}
