import java.util.List;
import java.util.Locale;

/**
 * Convert a phrase to its acronym.
 * <p>
 * Techies love their TLA (Three Letter Acronyms)!
 * <p>
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  private final String phrase;

  Acronym(String phrase) {
    this.phrase = phrase;
  }

  String get() {
    String cleanedPhrase = phrase.replaceAll("-|_", " ");
    List<String> words = convertPhraseToListOfWords(cleanedPhrase);
    String acronym = "";
    for (String word : words){
      acronym += word.toUpperCase(Locale.ROOT).charAt(0);
    }
    return acronym;
  }

  private List<String> convertPhraseToListOfWords(String phrase){
    return List.of(phrase.toLowerCase(Locale.ROOT).split("\\s+"));
  }

}
