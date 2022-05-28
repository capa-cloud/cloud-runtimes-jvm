package group.rxcloud.cloudruntimes.domain;

import group.rxcloud.cloudruntimes.domain.nativeproto.NativeRedisRuntimes;
import group.rxcloud.cloudruntimes.domain.nativeproto.NativeSqlRuntimes;

/**
 * Native Protocol Cloud Runtimes standard API defined.
 */
public interface NativeProtocolCloudRuntimes extends
        NativeRedisRuntimes,
        NativeSqlRuntimes {
}
