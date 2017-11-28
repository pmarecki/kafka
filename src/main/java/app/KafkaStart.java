package app;

import app.config.AppConfig;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;


public class KafkaStart {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        KafkaTemplate<String, String> kafkaTemplate = ctx.getBean(KafkaTemplate.class);
        kafkaTemplate.send("test", "AbraKadabra");

    }
}