package company.messaging.exchanges;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.TopicExchange;

public class QueueExchange extends TopicExchange {
    public static final String NAME = "queue-exchange";
    public static final String QUEUE_NAME = "queue";
    public static final String TYPE = ExchangeTypes.TOPIC;

    public QueueExchange() {
        super(NAME, true, false);
    }
}
