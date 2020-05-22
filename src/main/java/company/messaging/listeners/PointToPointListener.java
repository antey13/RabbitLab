package company.messaging.listeners;


import com.rabbitmq.client.Channel;
import company.messaging.exchanges.DirectListener;
import company.model.PublishedEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Component
public class PointToPointListener {

    @SneakyThrows
    @DirectListener
    @SendTo("response_point")
    public PublishedEntity processMessage(@RequestBody PublishedEntity message,
                                          Channel channel,
                                          @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        log.info("received message: {}", message.getMessage());
        Thread.sleep(5_000);
        message.setMessage("From PointToPointListener");
        if(message.getMessage().contains("reject"))
            channel.basicReject(tag,false);
        return message;
    }
}
