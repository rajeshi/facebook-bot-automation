package com.gilly.automation_framework.har.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "method",
    "url",
    "httpVersion",
    "cookies",
    "headers",
    "queryString",
    "postData",
    "headersSize",
    "bodySize"
})
public class Request {

    @JsonProperty("method")
    private String method;
    @JsonProperty("url")
    private String url;
    @JsonProperty("httpVersion")
    private String httpVersion;
    @JsonProperty("cookies")
    private List<Cooky> cookies = new ArrayList<Cooky>();
    @JsonProperty("headers")
    private List<Header> headers = new ArrayList<Header>();
    @JsonProperty("queryString")
    private List<QueryString> queryString = new ArrayList<QueryString>();
    @JsonProperty("postData")
    private PostData postData;
    @JsonProperty("headersSize")
    private Integer headersSize;
    @JsonProperty("bodySize")
    private Integer bodySize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return The method
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     *
     * @param method The method
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     *
     * @return The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return The httpVersion
     */
    @JsonProperty("httpVersion")
    public String getHttpVersion() {
        return httpVersion;
    }

    /**
     *
     * @param httpVersion The httpVersion
     */
    @JsonProperty("httpVersion")
    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    /**
     *
     * @return The cookies
     */
    @JsonProperty("cookies")
    public List<Cooky> getCookies() {
        return cookies;
    }

    /**
     *
     * @param cookies The cookies
     */
    @JsonProperty("cookies")
    public void setCookies(List<Cooky> cookies) {
        this.cookies = cookies;
    }

    /**
     *
     * @return The headers
     */
    @JsonProperty("headers")
    public List<Header> getHeaders() {
        return headers;
    }

    /**
     *
     * @param headers The headers
     */
    @JsonProperty("headers")
    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    /**
     *
     * @return The queryString
     */
    @JsonProperty("queryString")
    public List<QueryString> getQueryString() {
        return queryString;
    }

    /**
     *
     * @param queryString The queryString
     */
    @JsonProperty("queryString")
    public void setQueryString(List<QueryString> queryString) {
        this.queryString = queryString;
    }

    /**
     *
     * @return The postData
     */
    @JsonProperty("postData")
    public PostData getPostData() {
        return postData;
    }

    /**
     *
     * @param postData The postData
     */
    @JsonProperty("postData")
    public void setPostData(PostData postData) {
        this.postData = postData;
    }

    /**
     *
     * @return The headersSize
     */
    @JsonProperty("headersSize")
    public Integer getHeadersSize() {
        return headersSize;
    }

    /**
     *
     * @param headersSize The headersSize
     */
    @JsonProperty("headersSize")
    public void setHeadersSize(Integer headersSize) {
        this.headersSize = headersSize;
    }

    /**
     *
     * @return The bodySize
     */
    @JsonProperty("bodySize")
    public Integer getBodySize() {
        return bodySize;
    }

    /**
     *
     * @param bodySize The bodySize
     */
    @JsonProperty("bodySize")
    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
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
