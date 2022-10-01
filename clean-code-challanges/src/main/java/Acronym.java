import java.util.Locale;
/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  private String phrase;
  Acronym(String phrase) {
    this.phrase = phrase;
  }

  String get() {
    this.phrase = replaceSpecialChars();
    this.phrase = cleanupSpaces();
    this.phrase = getFirstCharsAfterSpaces();
    return this.phrase;
  }

  private String getFirstCharsAfterSpaces() {
    String resultString = "";
    String[] words = phrase.split(" ");
    for(String word : words) {
      resultString += word.substring(0,1).toUpperCase(Locale.ROOT);
    }
    return resultString;
  }
  private String replaceSpecialChars() {
    return phrase.replaceAll("[^a-zA-Z0-9']", " ");
  }
  private String cleanupSpaces() {
    return phrase.replaceAll("\\s{2,}", " ").trim();
  }

}
