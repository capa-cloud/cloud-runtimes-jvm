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
package group.rxcloud.cloudruntimes.domain.core.invocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * HTTP Extension class.
 * This class is only needed if the app you are calling is listening on HTTP.
 * It contains properties that represent data that may be populated for an HTTP receiver.
 */
public final class HttpExtension {

    /**
     * Convenience HttpExtension object for {@link HttpMethods#NONE} with empty queryString.
     */
    public static final HttpExtension NONE = new HttpExtension(HttpMethods.NONE);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#GET} Verb with empty queryString.
     */
    public static final HttpExtension GET = new HttpExtension(HttpMethods.GET);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#PUT} Verb with empty queryString.
     */
    public static final HttpExtension PUT = new HttpExtension(HttpMethods.PUT);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#POST} Verb with empty queryString.
     */
    public static final HttpExtension POST = new HttpExtension(HttpMethods.POST);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#DELETE} Verb with empty queryString.
     */
    public static final HttpExtension DELETE = new HttpExtension(HttpMethods.DELETE);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#HEAD} Verb with empty queryString.
     */
    public static final HttpExtension HEAD = new HttpExtension(HttpMethods.HEAD);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#CONNECT} Verb with empty queryString.
     */
    public static final HttpExtension CONNECT = new HttpExtension(HttpMethods.CONNECT);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#OPTIONS} Verb with empty queryString.
     */
    public static final HttpExtension OPTIONS = new HttpExtension(HttpMethods.OPTIONS);
    /**
     * Convenience HttpExtension object for the {@link HttpMethods#TRACE} Verb with empty queryString.
     */
    public static final HttpExtension TRACE = new HttpExtension(HttpMethods.TRACE);

    /**
     * HTTP verb.
     */
    private HttpMethods method;

    /**
     * HTTP query params.
     */
    private Map<String, List<String>> queryParams;

    /**
     * HTTP headers.
     */
    private Map<String, String> headers;

    /**
     * Construct a HttpExtension object.
     *
     * @param method      Required value denoting the HttpMethod.
     * @param queryParams map for the query parameters the HTTP call.
     * @param headers     map to set HTTP headers.
     * @throws IllegalArgumentException on null method or queryString.
     * @see HttpMethods for supported methods.
     */
    public HttpExtension(HttpMethods method,
                         Map<String, List<String>> queryParams,
                         Map<String, String> headers) {
        if (method == null) {
            throw new IllegalArgumentException("HttpExtension method cannot be null");
        }

        this.method = method;
        this.queryParams = Collections.unmodifiableMap(queryParams == null ? Collections.emptyMap() : queryParams);
        this.headers = Collections.unmodifiableMap(headers == null ? Collections.emptyMap() : headers);
    }

    /**
     * Construct a HttpExtension object.
     *
     * @param method Required value denoting the HttpMethod.
     * @throws IllegalArgumentException on null method or queryString.
     * @see HttpMethods for supported methods.
     */
    public HttpExtension(HttpMethods method) {
        this(method, null, null);
    }

    public HttpMethods getMethod() {
        return method;
    }

    public Map<String, List<String>> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * HTTP Methods supported.
     */
    public enum HttpMethods {
        NONE,
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        CONNECT,
        OPTIONS,
        TRACE
    }
}
