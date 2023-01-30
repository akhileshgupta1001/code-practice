package QueueSystem;

import QueueSystem.model.Message;
import QueueSystem.model.Topic;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final QueueSystem.Queue queue = new QueueSystem.Queue();
        final Topic topic1 = queue.createTopic("t1");
        final Topic topic2 = queue.createTopic("t2");
        final QueueSystem.SleepingSubscriber sub1 = new QueueSystem.SleepingSubscriber("sub1", 10000);
        final QueueSystem.SleepingSubscriber sub2 = new QueueSystem.SleepingSubscriber("sub2", 10000);
        queue.subscribe(sub1, topic1);
        queue.subscribe(sub2, topic1);

        final QueueSystem.SleepingSubscriber sub3 = new QueueSystem.SleepingSubscriber("sub3", 5000);
        queue.subscribe(sub3, topic2);

        queue.publish(topic1, new Message("m1"));
        queue.publish(topic1, new Message("m2"));

        queue.publish(topic2, new Message("m3"));

        Thread.sleep(15000);
        queue.publish(topic2, new Message("m4"));
        queue.publish(topic1, new Message("m5"));

        queue.resetOffset(topic1, sub1, 0);
    }
}
