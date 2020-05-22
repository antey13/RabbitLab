package company.messaging.producers;

import company.messaging.exchanges.PointToPointExchange;
import company.messaging.exchanges.QueueExchange;
import company.model.PublishedEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class TopicProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishMessage(PublishedEntity entity){
        rabbitTemplate.convertAndSend(QueueExchange.NAME,"kkk",entity);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = PointToPointExchange.QUEUE_NAME),
            exchange = @Exchange(name = PointToPointExchange.NAME, type = PointToPointExchange.TYPE),
            key = "response_topic"))
    public void receiverListener(@RequestBody PublishedEntity response){
        log.info("received responce {}", response.getMessage());
    }

}
