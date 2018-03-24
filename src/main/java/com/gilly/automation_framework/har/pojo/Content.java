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
    "mimeType",
    "size",
    "text",
    "compression"
})
public class Content {

    @JsonProperty("mimeType")
    private String mimeType;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("text")
    private Object text;
    @JsonProperty("compression")
    private Integer compression;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     *
     * @return The mimeType
     */
    @JsonProperty("mimeType")
    public String getMimeType() {
        return mimeType;
    }

    /**
     *
     * @param mimeType The mimeType
     */
    @JsonProperty("mimeType")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     *
     * @return The size
     */
    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size The size
     */
    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return The text
     */
    @JsonProperty("text")
    public Object getText() {
        return text;
    }

    /**
     *
     * @param text The text
     */
    @JsonProperty("text")
    public void setText(Object text) {
        this.text = text;
    }
    
     /**
     *
     * @return The compression
     */

    @JsonProperty("compression")
    public Integer getCompression() {
        return compression;
    }

    /**
     *
     * @param compression The text
     */
    @JsonProperty("compression")
    public void setCompression(Integer compression) {
        this.compression = compression;
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
