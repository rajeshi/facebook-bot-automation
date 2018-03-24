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
"version",
"creator",
"browser",
"pages",
"entries"
})
public class Log {

@JsonProperty("version")
private String version;
@JsonProperty("creator")
private Creator creator;
@JsonProperty("browser")
private Browser browser;
@JsonProperty("pages")
private List<Page> pages = new ArrayList<Page>();
@JsonProperty("entries")
private List<Entry> entries = new ArrayList<Entry>();
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The version
*/
@JsonProperty("version")
public String getVersion() {
return version;
}

/**
* 
* @param version
* The version
*/
@JsonProperty("version")
public void setVersion(String version) {
this.version = version;
}

/**
* 
* @return
* The creator
*/
@JsonProperty("creator")
public Creator getCreator() {
return creator;
}

/**
* 
* @param creator
* The creator
*/
@JsonProperty("creator")
public void setCreator(Creator creator) {
this.creator = creator;
}

/**
* 
* @return
* The browser
*/
@JsonProperty("browser")
public Browser getBrowser() {
return browser;
}

/**
* 
* @param browser
* The browser
*/
@JsonProperty("browser")
public void setBrowser(Browser browser) {
this.browser = browser;
}

/**
* 
* @return
* The pages
*/
@JsonProperty("pages")
public List<Page> getPages() {
return pages;
}

/**
* 
* @param pages
* The pages
*/
@JsonProperty("pages")
public void setPages(List<Page> pages) {
this.pages = pages;
}

/**
* 
* @return
* The entries
*/
@JsonProperty("entries")
public List<Entry> getEntries() {
return entries;
}

/**
* 
* @param entries
* The entries
*/
@JsonProperty("entries")
public void setEntries(List<Entry> entries) {
this.entries = entries;
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
