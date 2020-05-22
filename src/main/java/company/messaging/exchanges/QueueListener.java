package company.messaging.exchanges;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RabbitListener(bindings = @QueueBinding(value = @Queue(name = QueueExchange.QUEUE_NAME),
        exchange = @Exchange(name = QueueExchange.NAME, type = QueueExchange.TYPE),
        key = "*"))
public @interface QueueListener {
}
