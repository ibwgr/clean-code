/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {

  private String phrase;
  private String acronym = "";

  Acronym(String phrase) {
    this.phrase = phrase;
  }

  String get() {
    String adaptedPhrase = phrase.replaceAll("[_]", "");
    adaptedPhrase = removeConsecutiveDelimiters(adaptedPhrase);

    acronym += adaptedPhrase.toUpperCase().charAt(0);
    checkAfterEndOfWord(adaptedPhrase);
    return acronym;
  }

  private String removeConsecutiveDelimiters(String phrase) {
    if (phrase.contains(" -")) {
      phrase = phrase.replace(" -", "");
    }
    return phrase;
  }

  private void checkAfterEndOfWord(String phrase) {
    for (int i = 1; i <= phrase.length(); i++) {
      if (phrase.charAt(i - 1) == ' ' || phrase.charAt(i - 1) == '-') {
        acronym += phrase.toUpperCase().charAt(i);
      }
    }
  }

}
