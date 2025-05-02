package HW3.Controller;

import java.io.IOException;

public class BookException extends IOException {
    public BookException() {

    }
    public BookException(String message) {
        super(message);
    }
}
