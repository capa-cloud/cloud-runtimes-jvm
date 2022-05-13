/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package group.rxcloud.cloudruntimes.domain.core;

import group.rxcloud.cloudruntimes.domain.core.pubsub.PublishEventRequest;
import group.rxcloud.cloudruntimes.domain.core.pubsub.TopicEventRequest;
import group.rxcloud.cloudruntimes.domain.core.pubsub.TopicSubscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Publish and Subscribe Runtimes standard API defined.
 */
public interface PubSubRuntimes {

    // -- Runtime as Publisher

    /**
     * Publish an event.
     *
     * @param pubsubName the pubsub name we will publish the event to
     * @param topicName  the topicName where the event will be published.
     * @param data       the event's data to be published, use byte[] for skipping serialization.
     * @return a Mono plan of type String. <pre> Please note that this is different from the standard definition. Return {@code String} refer to https://github.com/capa-cloud/cloud-runtimes-jvm/issues/1 </pre>
     */
    Mono<String> publishEvent(String pubsubName, String topicName, Object data);

    /**
     * Publish an event.
     *
     * @param pubsubName the pubsub name we will publish the event to
     * @param topicName  the topicName where the event will be published.
     * @param data       the event's data to be published, use byte[] for skipping serialization.
     * @param metadata   The metadata for the published event.
     * @return a Mono plan of type String. <pre> Please note that this is different from the standard definition. Return {@code String} refer to https://github.com/capa-cloud/cloud-runtimes-jvm/issues/1 </pre>
     */
    Mono<String> publishEvent(String pubsubName, String topicName, Object data, Map<String, String> metadata);

    /**
     * Publish an event.
     *
     * @param request the request for the publish event.
     * @return a Mono plan of a CloudRuntimes's String response.
     * <pre>
     * Please note that this is different from the standard definition.
     * Return {@code String} refer to https://github.com/capa-cloud/cloud-runtimes-jvm/issues/1
     * </pre>
     */
    Mono<String> publishEvent(PublishEventRequest request);

    // -- Runtime as Subscriber

    /**
     * Subscribe events.
     *
     * @param pubsubName the pubsub name we will subscribe the event from.
     * @param topicName  the topicName where the event will be subscribed.
     * @param metadata   The metadata for the subscription.
     * @return a Flux stream of subscription events.
     */
    Flux<TopicEventRequest> subscribeEvents(String pubsubName, String topicName, Map<String, String> metadata);

    /**
     * Subscribe events.
     *
     * @param topicSubscription the request for topic subscription.
     * @return a Flux stream of subscription events.
     */
    Flux<TopicEventRequest> subscribeEvents(TopicSubscription topicSubscription);
}
