package syncpack;

import java.util.*;

public class SyncStack {
  private List<Character> buffer
    = new ArrayList<Character>(400);

  synchronized  public  char pop() {
    char c;
    while (buffer.size() == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        // ignore it...
      }
    }
    c = buffer.remove(buffer.size()-1);
    return c;
  }

  synchronized   public  void push(char c) {
   
    buffer.add(c);
    this.notify();
  }
}
