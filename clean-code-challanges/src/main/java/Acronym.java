import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Convert a phrase to its acronym.
 * <p>
 * Techies love their TLA (Three Letter Acronyms)!
 * <p>
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  Predicate<String> isLetter = Pattern.compile("[a-zA-Z]").asPredicate();
  String acronym;

  Acronym(String phrase) {
    var normalized = phrase.trim();
    var parts = normalized.split("[ _-]");
    acronym = Stream.of(parts)
      .filter(part -> part.length() > 0)
      .map(part -> part.substring(0, 1))
      .filter(isLetter)
      .collect(Collectors.joining())
      .toUpperCase();
  }

  String get() {
    return acronym.toUpperCase();
  }
}
