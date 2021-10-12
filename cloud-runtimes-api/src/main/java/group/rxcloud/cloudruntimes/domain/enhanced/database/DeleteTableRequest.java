package group.rxcloud.cloudruntimes.domain.enhanced.database;

import java.util.Map;

public class DeleteTableRequest {

    private String sql;
    private String connectionKey;
    private Map<String, String> metadata;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
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
