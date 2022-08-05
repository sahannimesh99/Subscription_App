package com.sahan;

import com.sahan.observer.SubscriptionSubject;
import com.sahan.observer.SubscriptionObserverImpl;
import com.sahan.view.SubscriberScreen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Sahan Nimesha
 */

public class handlerTest {

    private SubscriptionObserverImpl subscriptionObserver ;

    @Before
    public void init() {
        subscriptionObserver = new SubscriptionObserverImpl();
    }

    @Test
    public void CreateChannel() throws RuntimeException {
        subscriptionObserver.createChannel("Test Channel");
        assertEquals(1,SubscriptionObserverImpl.subject.size());
    }

    @Test
    public void subscribeChannelTest() throws RuntimeException {
        subscriptionObserver.createChannel("Test Channel");
        subscriptionObserver.subscribeChannel("Test Channel", new SubscriberScreen());
        assertEquals(1, SubscriptionObserverImpl.subject.get("Test Channel").size());
    }

    @Test
    public void unSubscribeChannelTest() throws RuntimeException {
        subscriptionObserver.createChannel("Test Channel");
        SubscriptionSubject sub = new SubscriberScreen();
        subscriptionObserver.subscribeChannel("Test Channel", sub);
        subscriptionObserver.unSubscribeChannel("Test Channel",sub);
        assertEquals(0, SubscriptionObserverImpl.subject.get("Test Channel").size());
    }

    @Test
    public void sendMessageTest() throws RuntimeException {
        SubscriptionSubject subscriber = notification -> {
            assertEquals("Published Contents",notification);
        };
        subscriptionObserver.subscribeChannel("Test Channel",subscriber);
        subscriptionObserver.sendMessage("Test Channel","Published Contents");
    }
}
