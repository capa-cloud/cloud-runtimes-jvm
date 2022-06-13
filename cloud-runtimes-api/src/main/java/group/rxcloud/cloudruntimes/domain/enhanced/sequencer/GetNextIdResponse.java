package group.rxcloud.cloudruntimes.domain.enhanced.sequencer;

public class GetNextIdResponse {

    // The next unique id
    private int nextId;

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    @Override
    public String toString() {
        return "GetNextIdResponse{" +
                "nextId=" + nextId +
                '}';
    }
}
