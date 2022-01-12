package group.rxcloud.cloudruntimes.domain.enhanced;

import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeGeoCommands;
import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeHashCommands;
import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeKeyCommands;
import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeListCommands;
import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeSetCommands;
import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeSortedSetCommands;
import group.rxcloud.cloudruntimes.domain.enhanced.redis.NativeStringCommands;

public interface RedisRuntimes extends NativeKeyCommands, NativeHashCommands, NativeSetCommands,
        NativeListCommands, NativeSortedSetCommands, NativeStringCommands, NativeGeoCommands {
}
