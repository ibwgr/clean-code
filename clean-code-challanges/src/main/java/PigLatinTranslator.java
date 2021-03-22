import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Implement a program that translates from English to Pig Latin.
 *
 * Pig Latin is a made-up children's language that's intended to be confusing. It obeys a few simple rules (below),
 * but when it's spoken quickly it's really difficult for non-children (and non-native speakers) to understand.
 *
 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
 *  Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
 * Rule 2: If a word begins with a consonant sound, move it to the end of the word and then add an "ay" sound to the end of the word.
 *  Consonant sounds can be made up of multiple consonants, a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
 * Rule 3: If a word starts with a consonant sound followed by "qu", move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
 * Rule 4: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").
 *
 * There are a few more rules for edge cases, and there are regional variants too.
 *
 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
 */
public class PigLatinTranslator {

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
