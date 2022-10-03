import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name like Portable Network Graphics to its acronym (PNG).
 */
class Acronym {
  public static void main(String[] args) {
    new Acronym("First In, First Out").get();
  }
  String text;

  Acronym(String phrase) {
    text = phrase;
  }

  String get() {
    String result = String.valueOf(text.charAt(0));
    String regexStr ="(?<=\\s)(?!_)(?!-).|(?<=-)(?!\\s).|(?<=_)(?!\\s)."; //(?<=\s)(?!_).|(?<=-).|(?<=_)(?!\s).
    Pattern pattern = Pattern.compile(regexStr);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()){
      result = result + matcher.group();
    }
    return result = result.toUpperCase();
  }
}
