package group.rxcloud.cloudruntimes.domain.nativeproto.redis;

/**
 * The Native debugging commands.
 *
 * @link <a href="http://redisdoc.com/debug/index.html">debug</a>
 */
public interface NativeDebugCommands {

    /**
     * @return <code>PONG</code>
     */
    String ping();

    // TODO: 2022/5/28 ECHO
    // TODO: 2022/5/28 OBJECT
    // TODO: 2022/5/28 SLOWLOG
    // TODO: 2022/5/28 MONITOR
    // TODO: 2022/5/28 DEBUG_OBJECT
    // TODO: 2022/5/28 DEBUG_SEGFAULT
}
