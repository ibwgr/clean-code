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
    this.phrase = phrase;
  }

  String get() {
    String separators = "[-_\\s]+";
    return
      Arrays.stream(phrase.toUpperCase().split(separators))
        .map(this::getInitialLetter)
        .collect(Collectors.joining(""));
  }

  private String getInitialLetter(String word){
    char firstChar = word.charAt(0);
    return Character.toString(firstChar);
  }

}
