package QueueSystem;

import QueueSystem.model.Message;

public interface ISubscriber {
    public String getId();
    public void consume(Message message) throws InterruptedException;
}
