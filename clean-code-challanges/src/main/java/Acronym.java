import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  private final String cleanedPhrase;
  private final String whitespaces = "\\s";

  Acronym(String phrase) {
    phrase = phrase.replaceAll("-", " ");
    this.cleanedPhrase = phrase.replaceAll("[^A-Za-z" + whitespaces + "]", "");
  }

  String get() {
    return Arrays.stream(cleanedPhrase.split(whitespaces))
      .filter(s -> !s.isEmpty())
      .map(s -> s.toUpperCase().charAt(0))
      .map(Object::toString)
      .collect(Collectors.joining());
  }
}
