import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    String movable;
    if (plusAy) {
      movable = "";
    } else if (quCluster.find()) {
      movable = quCluster.group(1);
    } else if (consonantCluster.find()) {
      movable = consonantCluster.group(1);
    } else {
      movable = word.substring(0, 1);
    }

    return moveToEnd(word, movable) + ay;
  }

  private String moveToEnd(String word, String movable) {
    return word.substring(movable.length()) + movable;
  }
}
