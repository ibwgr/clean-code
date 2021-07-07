
public class PigLatinTranslator {


  public static String translate(String englishPhrase) {


    String translation = "";

    String[] word = englishPhrase.split(" ");

    for (int w = 0; w < word.length; w++) {

      translation += " ";

      boolean isVowel = PigLatinTranslator.findFirstVowel(word[w].charAt(0));


      String quCluster = word[w].substring(1, 3);


      if (isVowel) {

        translation = translation + word[w] + "ay";

      } else if (word[w].substring(0, 2).equals("xr") || word[w].substring(0, 2).equals("yt")) {

        translation = translation + word[w] + "ay";

      } else if (quCluster.equals("qu")) {

        translation = word[w].substring(3) + word[w].substring(0, 1) + quCluster + "ay";

      } else if (word[w].substring(0, 2).equals("qu")) {

        translation = word[w].substring(2) + word[w].substring(0, 2) + "ay";
      } else {

        String cluster = PigLatinTranslator.findConsonantCluster(word[w]);
        translation += word[w].substring(word[w].indexOf(cluster) + cluster.length()) + cluster + "ay";
      }
    }
    return translation.trim();
  }


  private static boolean findFirstVowel(char firstLetter){

    String vowels = "aeiou";

    boolean isVowel = false;

    for (int i = 0; i < vowels.length(); i++){

      char vowel = vowels.charAt(i);

      if (vowel == firstLetter){

        isVowel = true;

        break;
      }
    }

    return isVowel;
  }

  private static String findConsonantCluster(String cluster){

    String consCluster = "";

    for (int i = 0; i < cluster.length(); i++){

      if (PigLatinTranslator.findFirstVowel(cluster.charAt(i)) ) {

        break;
      }

      else {

        consCluster += cluster.charAt(i);
      }
    }

    return consCluster;
  }


  public static void main(String[] args){

    translate("square hallo du");
  }
}
