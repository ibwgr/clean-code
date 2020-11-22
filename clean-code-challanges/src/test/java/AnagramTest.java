import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AnagramTest {

  @Test
  public void testNoMatches() {
    Anagram detector = new Anagram("diaper");
    assertTrue(detector.match(Arrays.asList("hello", "world", "zombies", "pants")).isEmpty());
  }

  @Test
  public void testDetectSimpleAnagram() {
    Anagram detector = new Anagram("ant");
    List<String> anagram = detector.match(Arrays.asList("tan", "stand", "at"));
    assertThat(anagram, hasItem("tan"));
    assertThat(anagram.size(), is(1));
  }

  @Test
  public void testDetectLongerAnagram() {
    Anagram detector = new Anagram("listen");
    List<String> anagrams = detector.match(Arrays.asList("enlists", "google", "inlets", "banana"));
    assertThat(anagrams, hasItem("inlets"));
  }

  @Test
  public void testDetectMultipleAnagrams() {
    Anagram detector = new Anagram("master");
    List<String> anagrams = detector.match(Arrays.asList("stream", "pigeon", "maters"));
    assertThat(anagrams, allOf(hasItem("maters"), hasItem("stream")));
  }

  @Test
  public void testDetectMultipleAnagramsForLongerWord() {
    Anagram detector = new Anagram("allergy");
    List<String> anagrams = detector.match(Arrays.asList("gallery", "ballerina", "regally", "clergy", "largely", "leading"));
    assertThat(anagrams, allOf(hasItem("gallery"), hasItem("largely"), hasItem("regally")));
  }

  @Test
  public void testDoesNotConfuseDifferentDuplicates() {
    Anagram detector = new Anagram("galea");
    assertTrue(detector.match(Arrays.asList("eagle")).isEmpty());
  }

  @Test
  public void testIdenticalWordIsNotAnagram() {
    Anagram detector = new Anagram("corn");
    List<String> anagrams = detector.match(Arrays.asList("corn", "dark", "Corn", "rank", "CORN", "cron", "park"));
    assertThat(anagrams, hasItem("cron"));
    assertThat(anagrams.size(), is(1));
  }

  @Test
  public void testIdenticalWordRepeatedIsNotAnagram() {
    Anagram detector = new Anagram("go");
    assertTrue(detector.match(Arrays.asList("go Go GO")).isEmpty());
  }

  @Test
  public void testCapitalWordIsNotOwnAnagram() {
    Anagram detector = new Anagram("BANANA");
    assertTrue(detector.match(Arrays.asList("Banana")).isEmpty());
  }

  @Test
  public void testEliminateAnagramsWithSameChecksum() {
    Anagram detector = new Anagram("mass");
    assertTrue(detector.match(Arrays.asList("last")).isEmpty());
  }

  @Test
  public void testEliminateAnagramSubsets() {
    Anagram detector = new Anagram("good");
    assertTrue(detector.match(Arrays.asList("dog", "goody")).isEmpty());
  }

  @Test
  public void testCaseInsensitiveWhenSubjectStartsWithUpperCaseLetter() {
    Anagram detector = new Anagram("Orchestra");
    List<String> anagrams = detector.match(Arrays.asList("cashregister", "carthorse", "radishes"));
    assertThat(anagrams, hasItem("carthorse"));
  }

  @Test
  public void testCaseInsensitiveWhenAnagramStartsWithUpperCaseLetter() {
    Anagram detector = new Anagram("orchestra");
    List<String> anagrams = detector.match(Arrays.asList("cashregister", "Carthorse", "radishes"));
    assertThat(anagrams, hasItem("Carthorse"));
  }

  @Test
  public void testCaseInsensitiveWhenBothAnagramAndSubjectStartWithUpperCaseLetter() {
    Anagram detector = new Anagram("Orchestra");
    List<String> anagrams = detector.match(Arrays.asList("cashregister", "Carthorse", "radishes"));
    assertThat(anagrams, hasItem("Carthorse"));
  }

  @Test
  public void testWordIsNotItsOwnAnagram() {
    Anagram detector = new Anagram("banana");
    assertTrue(detector.match(Arrays.asList("Banana")).isEmpty());
  }

  @Test
  public void testAnagramMustUseAllLettersExactlyOnce() {
    Anagram detector = new Anagram("tapper");
    assertTrue(detector.match(Arrays.asList("patter")).isEmpty());
  }
}
