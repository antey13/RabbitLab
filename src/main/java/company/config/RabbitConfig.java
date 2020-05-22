package company.config;

import company.util.Instance;
import org.springframework.amqp.rabbit.connection.ConnectionNameStrategy;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private String instanceId = Instance.getHostAddress();

    @Bean
    public ConnectionNameStrategy cns() {
        return f -> "LABKA-" + instanceId;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Jackson2XmlMessageConverter xmlMessageConverter(){
        return new Jackson2XmlMessageConverter();
    }
}
