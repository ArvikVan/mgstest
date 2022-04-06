package arv.mgstest.controller;

import arv.mgstest.model.HelloMessage;
import arv.mgstest.model.SimpleArray;
import arv.mgstest.service.EventServiceImpl;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @author ArvikV
 * @version 1.0
 * @since 06.04.2022
 */
@Controller
public class ArrController {
    private EventServiceImpl eventService;

    public ArrController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @MessageMapping("/arr")
    @SendTo("/topic/main-array")
    public SimpleArray showMainArray(HelloMessage message) throws Exception {
        return eventService.showMainArray(message);
    }

    @MessageMapping("/arr-sec")
    @SendTo("/topic/sec-array")
    public SimpleArray showGeneratedArray() throws Exception {
        return eventService.showGeneratedArray();
    }

    @MessageMapping("/arr-auto")
    @SendTo("/topic/auto-array")
    @Scheduled(fixedDelay = 10000)
    public SimpleArray showGeneratedAuto() throws InterruptedException {
        return eventService.showGeneratedAuto();
    }
}
