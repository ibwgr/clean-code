
/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  public final String phrase;
  private StringBuilder acronym = new StringBuilder();

  Acronym(String phrase) {
    this.phrase = phrase;
  }

  String get() {
    String[] words = phrase.replaceAll("-", " ").split(" ");
    for (String word : words) {
      if (!word.isEmpty()) {
        word = word.replaceAll("[^a-zA-Z0-9]", "");
        acronym.append(word.substring(0,1));
      }
    }
    return acronym.toString().toUpperCase();
  }

}
