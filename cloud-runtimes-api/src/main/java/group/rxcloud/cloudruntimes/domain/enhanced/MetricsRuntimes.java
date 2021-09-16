package group.rxcloud.cloudruntimes.domain.enhanced;

import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Metrics Runtimes standard API defined.
 */
public interface MetricsRuntimes {

    // see https://github.com/reactivegroup/cloud-runtimes-jvm/issues/2

    /*
     * transaction ： 跨越一段时间（请求）
     * event ： 感兴趣的事件（异常）
     * heartbeat : 周而复始发生的事件（GC）
     * metric ： 多维度数据统计指标（业务）
     */

    Mono<Void> startTransaction(String name, String type, Map<String, String> values);

    Mono<Void> endTransaction(String name, String type, Map<String, String> values);

    Mono<Void> logEvent(String name, String type, Map<String, String> values);

    Mono<Void> logHeartbeat(String name, String type, Map<String, String> values);

    Mono<Void> logMetric(String name, String type, Map<String, String> values);
}
