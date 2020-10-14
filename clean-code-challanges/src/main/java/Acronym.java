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
  private final String phrase;

  Acronym(String phrase) {
    this.phrase = phrase.replaceAll("[^A-Za-z\\s]", "");
  }

  String get() {
    System.out.println(phrase);
    return Arrays.stream(phrase.split("\\s"))
      .filter(s -> !s.isEmpty())
      .map(s -> s.toUpperCase().charAt(0))
      .map(Object::toString)
      .collect(Collectors.joining());

  }

}
