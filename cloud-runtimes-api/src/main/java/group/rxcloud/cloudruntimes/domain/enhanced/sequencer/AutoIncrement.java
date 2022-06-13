package group.rxcloud.cloudruntimes.domain.enhanced.sequencer;

/**
 * requirements for auto-increment guarantee
 */
public enum AutoIncrement {

    // (default) WEAK means a "best effort" incrementing service.But there is no strict guarantee of global monotonically increasing.
    // The next id is "probably" greater than current id.
    WEAK(0),
    // STRONG means a strict guarantee of global monotonically increasing.
    // The next id "must" be greater than current id.
    STRONG(1);

    private final int i;

    AutoIncrement(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
