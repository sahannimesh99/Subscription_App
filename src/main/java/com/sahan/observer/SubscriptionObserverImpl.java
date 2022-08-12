package com.sahan.observer;

import com.sahan.exception.AlreadySubscribedException;
import com.sahan.exception.DuplicateChannelException;
import com.sahan.exception.InvalidChannelException;
import com.sahan.exception.SubscriptionErrorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sahan.constant.AppConstant.*;

/**
 * @author Sahan Nimesha
 */

public class SubscriptionObserverImpl implements SubscriptionObserver {

    public static Map<String, List<SubscriptionSubject>> subject = new HashMap<>();

    @Override
    public void createChannel(String channel) {
        try {
            if (!channel.isEmpty() ) {
                if (!subject.containsKey(channel)) {
                    subject.put(channel, new ArrayList<>());
                } else {
                    throw new DuplicateChannelException(DUPLICATED_CHANNEL);
                }
            } else {
                throw new InvalidChannelException(INVALID_CHANNEL);
            }
        } catch (DuplicateChannelException ex) {
            throw new DuplicateChannelException(DUPLICATED_CHANNEL);
        }catch (InvalidChannelException ex) {
            throw new InvalidChannelException(INVALID_CHANNEL);
        }catch (Exception ex) {
            throw new RuntimeException(INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void subscribeChannel(String channel, SubscriptionSubject subscriptionSubject) {
        try {
            if (subject.containsKey(channel)) {
                List<SubscriptionSubject> subscribers = subject.get(channel);
                if (!subscribers.contains(subscriptionSubject)) {
                    subscribers.add(subscriptionSubject);
                } else {
                    throw new AlreadySubscribedException(DUPLICATED_SUBSCRIPTION);
                }
            } else {
                throw new InvalidChannelException(INVALID_CHANNEL);
            }

        } catch (AlreadySubscribedException ex) {
            throw new AlreadySubscribedException(DUPLICATED_SUBSCRIPTION);
        } catch (InvalidChannelException ex) {
            throw new InvalidChannelException(INVALID_CHANNEL);
        } catch (Exception ex) {
            throw new RuntimeException(INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void unSubscribeChannel(String channel, SubscriptionSubject subscriptionSubject) {
        try {
            if (subject.containsKey(channel)) {
                List<SubscriptionSubject> users = subject.get(channel);
                if (users.contains(subscriptionSubject)) {
                    users.remove(subscriptionSubject);
                } else {
                    throw new SubscriptionErrorException(NOT_SUBSCRIBED);
                }
            } else {
                throw new SubscriptionErrorException(NOT_SUBSCRIBED);
            }
        } catch (SubscriptionErrorException ex) {
            throw new SubscriptionErrorException(NOT_SUBSCRIBED);
        }catch (Exception ex) {
            throw new RuntimeException(INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void sendMessage(String channel, String body) {
        List<SubscriptionSubject> subscribers = subject.get(channel);
        subscribers.forEach((observer) -> observer.update(body));
    }
}
