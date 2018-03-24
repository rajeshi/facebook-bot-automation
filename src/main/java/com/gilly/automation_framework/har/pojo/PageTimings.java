/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    "onContentLoad",
    "onLoad"
})
public class PageTimings {

    @JsonProperty("onContentLoad")
    private Integer onContentLoad;
    @JsonProperty("onLoad")
    private Integer onLoad;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return The onContentLoad
     */
    @JsonProperty("onContentLoad")
    public Integer getOnContentLoad() {
        return onContentLoad;
    }

    /**
     *
     * @param onContentLoad The onContentLoad
     */
    @JsonProperty("onContentLoad")
    public void setOnContentLoad(Integer onContentLoad) {
        this.onContentLoad = onContentLoad;
    }

    /**
     *
     * @return The onLoad
     */
    @JsonProperty("onLoad")
    public Integer getOnLoad() {
        return onLoad;
    }

    /**
     *
     * @param onLoad The onLoad
     */
    @JsonProperty("onLoad")
    public void setOnLoad(Integer onLoad) {
        this.onLoad = onLoad;
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
