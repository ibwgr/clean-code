import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PigLatinUeli {
  private final String ay = "ay";
  private final Pattern quCluster = Pattern.compile("(^[^aeiouy]*qu)\\w+");
  private final Pattern consonantCluster = Pattern.compile("(^[^aeiouy]+)\\w+");
  private final List<String> plusAy = Collections.unmodifiableList(Arrays.asList("yt", "xr", "a", "e", "i", "o", "u"));

  public String translate(String englishPhrase) {
    String whiteSpaces = "\\s+";
    return Arrays.stream(englishPhrase.split(whiteSpaces))
      .map(this::pigify)
      .collect(Collectors.joining(" "));
  }

  private String pigify(String word) {
    boolean plusAy = this.plusAy.stream().anyMatch(word::startsWith);
    Matcher consonantCluster = this.consonantCluster.matcher(word);
    Matcher quCluster = this.quCluster.matcher(word);

    if (plusAy) {
      return moveToEnd(word, "");
    } else if (quCluster.find()) {
      return moveToEnd(word, quCluster.group(1));
    } else if (consonantCluster.find()) {
      return moveToEnd(word, consonantCluster.group(1));
    }

    return moveToEnd(word, word.substring(0, 1));
  }

  private String moveToEnd(String word, String movable) {
    return word.substring(movable.length()) + movable + ay;
  }
}
