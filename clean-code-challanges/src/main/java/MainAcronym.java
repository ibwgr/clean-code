import java.util.ArrayList;

/**
 * @author - John Schmidt
 * 19.09.2022, 00:44
 */
public class MainAcronym {

  public static void main(String[] args) {
    String phrase = "The Road _Not* Taken";

    System.out.println(get(phrase));
  }


  static String get(String phrase) {
    String acronym = "";
   // phrase.split(" ");

    System.out.println("split: "+phrase);

    char[] arrChar = new char[phrase.length()];

    for (int i = 0; i < phrase.length(); i++) {
      arrChar[i] = phrase.charAt(i);
    }

    acronym += arrChar[0];

    //ArrayList<String> arr = new ArrayList<>();
    String[] arr1= phrase.split(" ");
    System.out.println("l: "+arr1.length);
    for(int i = 0; i<arr1.length;i++){
      //arr[i] = phrase.charAt(i);
      System.out.println(arr1[i]);
    }
    for(int i = 1; i<phrase.length();i++){
      if((phrase.substring(i-1, i).equals(" ")&&phrase.substring(i).equals("_"))||phrase.substring(i-1, i).equals("-")&&!phrase.substring(i).equals("_")&&!phrase.substring(i-1,i).equals("_")){
        //arrChar[i] = Character.toUpperCase(phrase.charAt(i));
        acronym += Character.toUpperCase(phrase.charAt(i));
        //arr.add(phrase.charAt(i));//i) = Character.toUpperCase(phrase.charAt(i));
      }
    }


    for (int i = 0; i < arrChar.length; i++) {
      //.out.print(arr[i]);
      //acronym += arr.get(i);//[i];
      //acronym += arrChar[i];
    }

    return acronym;
  }

}
