package patterns.nonull;

import java.util.Optional;

public class Application {

  public Object getUser(String userId) {
    Optional<Object> user = new Database().findById(userId);

    return user.orElseThrow(() -> new IllegalArgumentException("user with given id not found"));
  }
}
