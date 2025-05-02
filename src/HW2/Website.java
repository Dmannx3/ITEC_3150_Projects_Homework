package HW2;

import java.io.Serializable;

public class Website implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String URL;

    public Website() {
        super();
        name = "";
        URL = "";
    }

    public Website(String name, String uRL) {
        super();
        this.name = name;
        URL = uRL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    @Override
    public String toString() {
        return "Website [name=" + name + ", URL=" + URL + "]";
    }
}
