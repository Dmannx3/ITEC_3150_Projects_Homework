package IAMMusic;

import java.io.IOException;

public class MusicException extends IOException {
    public MusicException() {

    }
    public MusicException(String message) {
        super(message);
    }
}
