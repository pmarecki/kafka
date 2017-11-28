package app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @RequestMapping(value = "/kafka-send", method = RequestMethod.GET)
    public String kafkaSend() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("0123456789");
        }
        String msg = sb.toString(); //1kB
        for (int i = 0; i < 10000; i++) {
            kafkaTemplate.send("test", msg);
        }
        return "OK";
    }

    @RequestMapping(value = "/app")
    public String showWebPage(ModelMap model) {
        return "burak";
    }


}
