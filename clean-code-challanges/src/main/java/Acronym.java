

/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {

  private String word;

  Acronym(String phrase) {

    this.word = phrase;
  }


  String get() {

    String cleanString = this.word.replaceAll("[\\-_]",  " ");
    String moreCleanerString = cleanString.trim().replaceAll("[ ]{2,}", " ");

    StringBuilder acronym = new StringBuilder();

    for (String s : moreCleanerString.split(" "))

      acronym.append(s.charAt(0));

    return acronym.toString().toUpperCase();
  }
}
