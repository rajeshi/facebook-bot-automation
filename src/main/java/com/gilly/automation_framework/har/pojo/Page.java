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
"startedDateTime",
"id",
"title",
"pageTimings"
})
public class Page {

@JsonProperty("startedDateTime")
private String startedDateTime;
@JsonProperty("id")
private String id;
@JsonProperty("title")
private String title;
@JsonProperty("pageTimings")
private PageTimings pageTimings;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The startedDateTime
*/
@JsonProperty("startedDateTime")
public String getStartedDateTime() {
return startedDateTime;
}

/**
* 
* @param startedDateTime
* The startedDateTime
*/
@JsonProperty("startedDateTime")
public void setStartedDateTime(String startedDateTime) {
this.startedDateTime = startedDateTime;
}

/**
* 
* @return
* The id
*/
@JsonProperty("id")
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

/**
* 
* @return
* The title
*/
@JsonProperty("title")
public String getTitle() {
return title;
}

/**
* 
* @param title
* The title
*/
@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

/**
* 
* @return
* The pageTimings
*/
@JsonProperty("pageTimings")
public PageTimings getPageTimings() {
return pageTimings;
}

/**
* 
* @param pageTimings
* The pageTimings
*/
@JsonProperty("pageTimings")
public void setPageTimings(PageTimings pageTimings) {
this.pageTimings = pageTimings;
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
