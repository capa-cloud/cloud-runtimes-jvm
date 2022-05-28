package group.rxcloud.cloudruntimes.domain.nativeproto.redis;

/**
 * The Native admin commands.
 *
 * @link <a href="http://redisdoc.com/configure/index.html">configure</a>
 * @link <a href="http://redisdoc.com/client_and_server/index.html">client_and_server</a>
 * @link <a href="http://redisdoc.com/replication/index.html">replication</a>
 */
public interface NativeAdminCommands {

    // -- configure

    // TODO: 2022/5/28 CONFIG_SET
    // TODO: 2022/5/28 CONFIG_GET
    // TODO: 2022/5/28 CONFIG_RESETSTAT
    // TODO: 2022/5/28 CONFIG_REWRITE

    // -- client_and_server

    // TODO: 2022/5/28 AUTH
    // TODO: 2022/5/28 QUIT
    // TODO: 2022/5/28 INFO
    // TODO: 2022/5/28 SHUTDOWN
    // TODO: 2022/5/28 TIME
    // TODO: 2022/5/28 CLIENT_GETNAME
    // TODO: 2022/5/28 CLIENT_KILL
    // TODO: 2022/5/28 CLIENT_LIST
    // TODO: 2022/5/28 CLIENT_SETNAME

    // -- replication

    // TODO: 2022/5/28 SLAVEOF
    // TODO: 2022/5/28 ROLE
}
