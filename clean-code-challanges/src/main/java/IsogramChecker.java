import java.util.HashSet;
import java.util.Set;

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
      Set<Character> chars = new HashSet<Character>();
      for (Character character : phrase.toCharArray()) {
        // characters to ignore
        if (character == ' ' || character == '-')
          continue;
        else if (chars.contains(Character.toUpperCase(character)))
          return false;
        else
          chars.add(Character.toUpperCase(character));
      }
      return true;
    }
  }
