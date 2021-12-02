package group.rxcloud.cloudruntimes.domain.enhanced.schedule;

public final class Metadata {

    public static final String MODE = "mode";

    public enum Mode {

        /**
         * mode
         */
        BROADCAST("broadcast"),
        UNICAST("unicast");

        private final String mode;

        Mode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }

    private Metadata() {
    }
}
