package group.rxcloud.cloudruntimes.domain.enhanced.database;

public class QueryResponse<T> {

    private int size;

    /**
     * it should be use json encode.  [{"id":2,"name":"jack"},{"id":4,"name":"anna"}]
     * if some dataType can't be recognized, we should use string types.
     * I think the component developer can decide the Serialize of this field , and the app develop should know
     * the deserialize of the field.
     */
    private T queryResult;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(T queryResult) {
        this.queryResult = queryResult;
    }
}
