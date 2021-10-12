package group.rxcloud.cloudruntimes.domain.enhanced.database;

public class UpdateResponse {

    /**
     * the size of rows are affected.
     */
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
