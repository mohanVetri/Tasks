package rest.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloWorld {
    public HelloWorld(String message) {
        this.message = message;
    }

    private String message; 

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
