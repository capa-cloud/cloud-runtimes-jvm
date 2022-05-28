package group.rxcloud.cloudruntimes.domain.nativeproto.redis;

/**
 * The Native database commands.
 *
 * @link <a href="http://redisdoc.com/database/index.html">database</a>
 */
public interface NativeDatabaseCommands {

    /**
     * Move key from the currently selected database to the specified destination database.
     * When key already exists in the destination database, or it does not exist in the source database, it does nothing.
     *
     * @param key     the key
     * @param dbIndex the db index
     * @return True if the key was removed in the db.
     */
    Boolean move(String key, int dbIndex);

    /**
     * Return the number of keys in the currently selected database.
     *
     * @return The number of keys
     */
    long dbSize();

    /**
     * Delete all the keys of the currently selected DB. This command never fails.
     *
     * @return OK
     */
    String flushDB();

    /**
     * Delete all the keys of all the existing databases, not just the currently selected one. This
     * command never fails.
     *
     * @return OK
     */
    String flushAll();

    /**
     * Select the DB with having the specified zero-based numeric index. For default every new
     * connection connection is automatically selected to DB 0.
     *
     * @param index db index
     * @return OK
     */
    String select(final int index);

    String swapDB(final int index1, final int index2);
}
