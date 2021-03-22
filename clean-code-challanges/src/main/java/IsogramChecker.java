import java.util.Set;
import java.util.stream.Collectors;

/**
 * Determine if a word or phrase is an isogram.
 *
 * An isogram (also known as a "nonpattern word") is a word or phrase without a repeating letter,
 * however spaces and hyphens are allowed to appear multiple times.
 *
 * Examples of isograms:
 *
 * lumberjacks
 * background
 * downstream
 * six-year-old
 *
 * The word isograms, however, is not an isogram, because the s repeats.
 */
class IsogramChecker {

  boolean isIsogram(String phrase) {
    String letters = phrase.replaceAll("[^a-zA-Z]", "").toLowerCase();
    Set<Character> distinctChars = letters.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    return distinctChars.size() == letters.length();
  }
}
