package group.rxcloud.cloudruntimes.domain.enhanced.sequencer;

import java.util.Map;

public class GetNextIdRequest {

    // Required. Name of sequencer storage
    private String storeName;
    // Required. key is the identifier of a sequencer namespace,e.g. "order_table".
    private String key;
    // (optional) SequencerOptions configures requirements for auto-increment guarantee
    private SequencerOptions options;
    // (optional) The metadata which will be sent to the component.
    private Map<String, String> metadata;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SequencerOptions getOptions() {
        return options;
    }

    public void setOptions(SequencerOptions options) {
        this.options = options;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "GetNextIdRequest{" +
                "storeName='" + storeName + '\'' +
                ", key='" + key + '\'' +
                ", options=" + options +
                ", metadata=" + metadata +
                '}';
    }
}
