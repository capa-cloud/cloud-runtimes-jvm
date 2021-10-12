package group.rxcloud.cloudruntimes.domain.enhanced.database;

import java.util.Map;

public class GetConnectionRequest {

    /**
     * use as the key;
     */
    private String url;

    private String username;
    private String password;

    private GetConnectionPoolOption poolOption;
    private Map<String, String> metadata;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GetConnectionPoolOption getPoolOption() {
        return poolOption;
    }

    public void setPoolOption(GetConnectionPoolOption poolOption) {
        this.poolOption = poolOption;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
