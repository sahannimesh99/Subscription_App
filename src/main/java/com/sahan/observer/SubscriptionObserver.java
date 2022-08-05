package com.sahan.observer;

/**
 *
 * @author Sahan Nimesha
 */

public interface SubscriptionObserver {
    void createChannel(String channel);

    void subscribeChannel(String channel, SubscriptionSubject subscriptionSubject);

    void unSubscribeChannel(String channel, SubscriptionSubject subscriptionSubject);

    void sendMessage(String channel, String message);

}

