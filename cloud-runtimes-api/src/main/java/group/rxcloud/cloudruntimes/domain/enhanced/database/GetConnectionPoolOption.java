package group.rxcloud.cloudruntimes.domain.enhanced.database;

public class GetConnectionPoolOption {

    /**
     * Use the connection pool or forbid to create new connection
     */
    private boolean pooled;

    private int maxIdleConns;
    private int maxOpenConns;

    private long maxLifeTime;
    private long maxIdleTime;

    public boolean isPooled() {
        return pooled;
    }

    public void setPooled(boolean pooled) {
        this.pooled = pooled;
    }

    public int getMaxIdleConns() {
        return maxIdleConns;
    }

    public void setMaxIdleConns(int maxIdleConns) {
        this.maxIdleConns = maxIdleConns;
    }

    public int getMaxOpenConns() {
        return maxOpenConns;
    }

    public void setMaxOpenConns(int maxOpenConns) {
        this.maxOpenConns = maxOpenConns;
    }

    public long getMaxLifeTime() {
        return maxLifeTime;
    }

    public void setMaxLifeTime(long maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }

    public long getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(long maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }
}
