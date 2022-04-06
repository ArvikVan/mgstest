package arv.mgstest.model;

/**
 * @author ArvikV
 * @version 1.0
 * @since 06.04.2022
 */
public class HelloMessage {
    private String name;


    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
