/*
package QueueSystem.handler;

import QueueSystem.model.Topic;
import QueueSystem.model.TopicSubscriber;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private final Topic topic;
    private final Map<String, QueueSystem.handler.SubscriberWorker> subscriberWorkers;

    public TopicHandler(@NonNull final Topic topic) {
        this.topic = topic;
        subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            startSubsriberWorker(topicSubscriber);
        }
    }

    public void startSubsriberWorker(@NonNull final TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }
}
*/
