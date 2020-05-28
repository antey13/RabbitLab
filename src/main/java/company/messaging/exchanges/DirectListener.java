package company.messaging.exchanges;

import org.springframework.amqp.rabbit.annotation.*;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RabbitListener(bindings = @QueueBinding(value = @Queue(name = PointToPointExchange.QUEUE_NAME /*, arguments = {@Argument(name = "x-message-ttl",value = "60_000")
                                                                                                                ,@Argument(name = "x-max-length",value= "10")}*/),
        exchange = @Exchange(name = PointToPointExchange.NAME, type = PointToPointExchange.TYPE),
        key = "specific_point"), ackMode = "MANUAL")
public @interface DirectListener {
}
