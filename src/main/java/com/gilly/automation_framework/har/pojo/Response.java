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
    "status",
    "statusText",
    "httpVersion",
    "cookies",
    "headers",
    "content",
    "redirectURL",
    "headersSize",
    "bodySize"
})
public class Response {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("statusText")
    private String statusText;
    @JsonProperty("httpVersion")
    private String httpVersion;
    @JsonProperty("cookies")
    private List<Object> cookies = new ArrayList<>();
    @JsonProperty("headers")
    private List<Header> headers = new ArrayList<>();
    @JsonProperty("content")
    private Content content;
    @JsonProperty("redirectURL")
    private String redirectURL;
    @JsonProperty("headersSize")
    private Integer headersSize;
    @JsonProperty("bodySize")
    private Integer bodySize;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     *
     * @return The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return The statusText
     */
    @JsonProperty("statusText")
    public String getStatusText() {
        return statusText;
    }

    /**
     *
     * @param statusText The statusText
     */
    @JsonProperty("statusText")
    public void setStatusText(String statusText) {
        this.statusText = statusText;
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
    public List<Object> getCookies() {
        return cookies;
    }

    /**
     *
     * @param cookies The cookies
     */
    @JsonProperty("cookies")
    public void setCookies(List<Object> cookies) {
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
     * @return The content
     */
    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    /**
     *
     * @param content The content
     */
    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     *
     * @return The redirectURL
     */
    @JsonProperty("redirectURL")
    public String getRedirectURL() {
        return redirectURL;
    }

    /**
     *
     * @param redirectURL The redirectURL
     */
    @JsonProperty("redirectURL")
    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
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
