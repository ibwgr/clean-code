import java.util.ArrayList;
import java.util.List;

/**
 * @author - John Schmidt
 * 18.09.2022, 14:18
 */
public class MainAnagram {
  public static void main(String[] args) {

    ArrayList<String> liste1 = new ArrayList<String>();
    liste1.add("enlist");
    liste1.add("google");
    liste1.add("inlets");
    liste1.add("banana");

    System.out.println(match(liste1));

  }

  public String alphabet(List<String> candidates){
    String alphabet = "abcdefghijklnmopqrstuvwxyz";


    return null;
  }

  public static List<String> match(List<String> candidates) {

    System.out.println("In übergebener Liste enthalten: ");
    for(int i = 0; i<candidates.size();i++){
      System.out.println(candidates.get(i));
    }

    ArrayList<String> list2 = new ArrayList<String>();
    list2.add("g");


    return list2;
  }

}
