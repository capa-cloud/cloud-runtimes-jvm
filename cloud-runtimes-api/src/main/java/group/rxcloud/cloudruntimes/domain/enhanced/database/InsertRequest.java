package group.rxcloud.cloudruntimes.domain.enhanced.database;

import java.util.List;
import java.util.Map;

public class InsertRequest {

    private String sql;

    /**
     * the arguments
     */
    private List<String> args;

    /**
     * the connectionKey is the connection identifier, the default value is the URL of database.
     */
    private String connectionKey;

    /**
     * the metadata, maybe the timeout or other parameters.
     */
    private Map<String, String> metadata;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public String getConnectionKey() {
        return connectionKey;
    }

    public void setConnectionKey(String connectionKey) {
        this.connectionKey = connectionKey;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
