package arv.mgstest.controller;

import arv.mgstest.model.Message;
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
    private final EventServiceImpl eventService;

    public ArrController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    /**
     * главная последовательность
     * @param message что шлем по тоннелю
     * @return на выходе сообщение с данными
     * @throws Exception ошибку ловим
     */
    @MessageMapping("/arr")
    @SendTo("/topic/main-array")
    public SimpleArray showMainArray(Message message) throws Exception {
        return eventService.showMainArray(message);
    }

    /**
     * генераци нескольких последовательностей
     * @return на выходе последовательности 5 штук по 6
     * @throws Exception ловим ошибку
     */
    @MessageMapping("/arr-sec")
    @SendTo("/topic/sec-array")
    public SimpleArray showGeneratedArray() throws Exception {
        return eventService.showGeneratedArray();
    }

    /**
     * генерация 1 в 10 сек
     * @return на вызоде последовательность
     * @throws InterruptedException ошибки ловим
     */
    @MessageMapping("/arr-auto")
    @SendTo("/topic/auto-array")
    @Scheduled(fixedDelay = 10000)
    public SimpleArray showGeneratedAuto() throws InterruptedException {
        return eventService.showGeneratedAuto();
    }
}
