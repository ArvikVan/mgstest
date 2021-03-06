package arv.mgstest.service;

import arv.mgstest.model.Message;
import arv.mgstest.model.SimpleArray;

/**
 * @author ArvikV
 * @version 1.0
 * @since 06.04.2022
 */
public interface EventService {
    public SimpleArray showMainArray(Message message) throws InterruptedException;
    public SimpleArray showGeneratedArray() throws InterruptedException;
    public SimpleArray showGeneratedAuto() throws InterruptedException;
}
