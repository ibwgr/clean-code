package patterns.nonull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

  public Optional<Object> findById(String userId) {
    List result = new ArrayList<>(); // executeSqlQuery("select * from users where id = ?", userId)
    if (result.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(result.get(0));
  }
}
