package company.web;

import company.messaging.producers.PointProducer;
import company.messaging.producers.TopicProducer;
import company.model.PublishedEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {
    @Autowired
    private PointProducer pointProducer;
    @Autowired
    private TopicProducer topicProducer;

    @PostMapping("/topic")
    public void publishToTopic(@RequestBody PublishedEntity publishedEntity){
        topicProducer.publishMessage(publishedEntity);
    }

    @PostMapping("/point")
    public void publishToPoint(@RequestBody PublishedEntity publishedEntity){
        pointProducer.publishMessage(publishedEntity);
    }
}
