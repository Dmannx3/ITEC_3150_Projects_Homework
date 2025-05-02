package IC5;

import java.io.IOException;

//Custom exception handler
public class GamerEntry extends IOException {
  public GamerEntry() {

  }
    public GamerEntry(String message) {
        super(message);
    }
}
