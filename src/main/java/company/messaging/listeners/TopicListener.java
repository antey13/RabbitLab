package company.messaging.listeners;

import com.rabbitmq.client.Channel;
import company.messaging.exchanges.QueueListener;
import company.model.PublishedEntity;
import company.util.Instance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Component
public class TopicListener {

    @SneakyThrows
    @QueueListener
    @SendTo("response_topic")
    public PublishedEntity processMessage(@RequestBody PublishedEntity message,
                                          Channel channel,
                                          @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        log.info("received message: {}. receiver id {}",message.getMessage(), Instance.getHostAddress());
        Thread.sleep(5000);
        //channel.basicAck(tag,true);
        return message;
    }
}
