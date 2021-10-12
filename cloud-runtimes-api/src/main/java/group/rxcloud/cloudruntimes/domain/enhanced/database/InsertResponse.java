package group.rxcloud.cloudruntimes.domain.enhanced.database;

public class InsertResponse {

    private int size;

    private String insertResult;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getInsertResult() {
        return insertResult;
    }

    public void setInsertResult(String insertResult) {
        this.insertResult = insertResult;
    }
}
