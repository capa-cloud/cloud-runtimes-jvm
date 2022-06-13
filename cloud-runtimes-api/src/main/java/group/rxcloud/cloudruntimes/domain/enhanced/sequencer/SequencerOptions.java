package group.rxcloud.cloudruntimes.domain.enhanced.sequencer;

/**
 * SequencerOptions configures requirements for auto-increment guarantee
 */
public class SequencerOptions {

    private AutoIncrement increment;

    public AutoIncrement getIncrement() {
        return increment;
    }

    public void setIncrement(AutoIncrement increment) {
        this.increment = increment;
    }
}
