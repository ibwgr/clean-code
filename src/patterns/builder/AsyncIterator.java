package patterns.builder;

public class AsyncIterator {

  /**
   * Creates a new iterator and starts it.
   *
   * Parameters:
   * 		(Runnable) callback - the function to be called, must return a future
   * 		(Integer)  delay - optional. The delay, no delay (or 0) will be ignored
   * 		(Integer)  maxIterations - optional. Maximum number of iterations that will be made
   * 								 no value (or 0) will run indefinitely until cancelled
   * 		(Boolean)  keepAlive - optional. If set to true, the interval service will not
   * 	                          automatically	be cancelled on a state change.
   */

  static void iterate(Runnable callback, Integer delay, Integer maxIterations, Boolean keepAlive){
    // callback.run();
  }

  static void iterate(Runnable callback, Builder config) {
    // callback.run();
    // config.delay;
  }

  static class Builder {
    private Integer delay;
    private Integer maxIterations;
    private Runnable callback;
    private Boolean keepAlive;

    Builder withDelay(Integer delay) {
      this.delay = delay;
      return this;
    }

    Builder maxIterations(Integer maxIterations) {
      this.maxIterations = maxIterations;
      return this;
    }

    Builder keepAlive(Boolean keepAlive) {
      this.keepAlive = keepAlive;
      return this;
    }

    static Builder noDelayForever() {
      return new Builder().withDelay(0).maxIterations(0);
    }
  }
}
