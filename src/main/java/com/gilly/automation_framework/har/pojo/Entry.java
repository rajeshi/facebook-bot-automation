package com.gilly.automation_framework.har.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "pageref",
    "startedDateTime",
    "time",
    "request",
    "response",
    "cache",
    "timings",
    "serverIPAddress",
    "connection"
})
public class Entry {

    @JsonProperty("pageref")
    private String pageref;
    @JsonProperty("startedDateTime")
    private String startedDateTime;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("request")
    private Request request;
    @JsonProperty("response")
    private Response response;
    @JsonProperty("cache")
    private Cache cache;
    @JsonProperty("timings")
    private Timings timings;
    @JsonProperty("serverIPAddress")
    private String serverIPAddress;
    @JsonProperty("connection")
    private String connection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return The pageref
     */
    @JsonProperty("pageref")
    public String getPageref() {
        return pageref;
    }

    /**
     *
     * @param pageref The pageref
     */
    @JsonProperty("pageref")
    public void setPageref(String pageref) {
        this.pageref = pageref;
    }

    /**
     *
     * @return The startedDateTime
     */
    @JsonProperty("startedDateTime")
    public String getStartedDateTime() {
        return startedDateTime;
    }

    /**
     *
     * @param startedDateTime The startedDateTime
     */
    @JsonProperty("startedDateTime")
    public void setStartedDateTime(String startedDateTime) {
        this.startedDateTime = startedDateTime;
    }

    /**
     *
     * @return The time
     */
    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    /**
     *
     * @param time The time
     */
    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     *
     * @return The request
     */
    @JsonProperty("request")
    public Request getRequest() {
        return request;
    }

    /**
     *
     * @param request The request
     */
    @JsonProperty("request")
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     *
     * @return The response
     */
    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }

    /**
     *
     * @param response The response
     */
    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     *
     * @return The cache
     */
    @JsonProperty("cache")
    public Cache getCache() {
        return cache;
    }

    /**
     *
     * @param cache The cache
     */
    @JsonProperty("cache")
    public void setCache(Cache cache) {
        this.cache = cache;
    }

    /**
     *
     * @return The timings
     */
    @JsonProperty("timings")
    public Timings getTimings() {
        return timings;
    }

    /**
     *
     * @param timings The timings
     */
    @JsonProperty("timings")
    public void setTimings(Timings timings) {
        this.timings = timings;
    }

    /**
     *
     * @return The serverIPAddress
     */
    @JsonProperty("serverIPAddress")
    public String getServerIPAddress() {
        return serverIPAddress;
    }

    /**
     *
     * @param serverIPAddress The serverIPAddress
     */
    @JsonProperty("serverIPAddress")
    public void setServerIPAddress(String serverIPAddress) {
        this.serverIPAddress = serverIPAddress;
    }

    /**
     *
     * @return The connection
     */
    @JsonProperty("connection")
    public String getConnection() {
        return connection;
    }

    /**
     *
     * @param connection The connection
     */
    @JsonProperty("connection")
    public void setConnection(String connection) {
        this.connection = connection;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
