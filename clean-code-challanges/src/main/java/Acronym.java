import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Convert a phrase to its acronym.
 * <p>
 * Techies love their TLA (Three Letter Acronyms)!
 * <p>
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  Predicate<String> isLetter = Pattern.compile("[a-zA-Z]").asPredicate();
  StringBuilder acronym = new StringBuilder();
  List<Character> delimiter = Collections.unmodifiableList(Arrays.asList(' ', '-', '_'));

  Acronym(String phrase) {
    var normalized = phrase.trim();
    acronym.append(normalized.charAt(0));

    var tokenIdx = 1;
    for (var token : normalized.substring(tokenIdx).toCharArray()) {

      if (isLetter.test(String.valueOf(token))) {
        var prevToken = normalized.charAt(tokenIdx - 1);
        if (delimiter.contains(prevToken)) {
          acronym.append(token);
        }
      }
      ++tokenIdx;
    }
  }

  String get() {
    return acronym.toString().toUpperCase();
  }
}
