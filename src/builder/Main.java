package builder;

public class Main {

  public Main() {
    Runnable callback = () -> System.out.println("");

    // Without Builder
    AsyncIterator.iterate(callback, 0, 10, false);

    // With Builder
    AsyncIterator.Builder config = new AsyncIterator.Builder().maxIterations(10);
    AsyncIterator.iterate(callback, config);
    AsyncIterator.iterate(callback, AsyncIterator.Builder.noDelayForever());
  }
}
