package arv.mgstest.model;

/**
 * @author ArvikV
 * @version 1.0
 * @since 06.04.2022
 */
public class Message {
    private String name;


    public Message() {
    }

    public Message(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
