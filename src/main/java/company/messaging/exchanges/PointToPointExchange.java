package company.messaging.exchanges;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.TopicExchange;

public class PointToPointExchange extends TopicExchange {
    public static final String NAME = "point-2-point-exchange";
    public static final String QUEUE_NAME = "point-queue";
    public static final String TYPE = ExchangeTypes.DIRECT;

    public PointToPointExchange() {
        super(NAME, true, false);
    }
}
