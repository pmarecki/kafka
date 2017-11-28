package app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MyKafkaListener {
    AtomicInteger msgCount = new AtomicInteger();
    @KafkaListener(topics = "test", group = "my_group_1")
    public void listen(String message) {
        if (msgCount.incrementAndGet() % 1000 == 0) {
            log.warn("Received Message #[{}]", msgCount.get());
        }
    }
}
