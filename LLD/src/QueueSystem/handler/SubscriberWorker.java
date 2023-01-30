package QueueSystem.handler;

import QueueSystem.model.Message;
import QueueSystem.model.Topic;
import QueueSystem.model.TopicSubscriber;

public class SubscriberWorker implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(final Topic topic, final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                try {
                    int curOffset = topicSubscriber.getOffset().get();
                    while (curOffset >= topic.getMessages().size()) {
                        topicSubscriber.wait();
                    }
                    Message message = topic.getMessages().get(curOffset);
                    topicSubscriber.getSubscriber().consume(message);

                    // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                    // consuming we need to increase only if it was previous one.
                    topicSubscriber.getOffset().compareAndSet(curOffset, curOffset + 1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
