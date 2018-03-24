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
    "blocked",
    "dns",
    "connect",
    "send",
    "wait",
    "receive"
})
public class Timings {

    @JsonProperty("blocked")
    private Integer blocked;
    @JsonProperty("dns")
    private Integer dns;
    @JsonProperty("connect")
    private Integer connect;
    @JsonProperty("send")
    private Integer send;
    @JsonProperty("wait")
    private Integer wait;
    @JsonProperty("receive")
    private Integer receive;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     *
     * @return The blocked
     */
    @JsonProperty("blocked")
    public Integer getBlocked() {
        return blocked;
    }

    /**
     *
     * @param blocked The blocked
     */
    @JsonProperty("blocked")
    public void setBlocked(Integer blocked) {
        this.blocked = blocked;
    }

    /**
     *
     * @return The dns
     */
    @JsonProperty("dns")
    public Integer getDns() {
        return dns;
    }

    /**
     *
     * @param dns The dns
     */
    @JsonProperty("dns")
    public void setDns(Integer dns) {
        this.dns = dns;
    }

    /**
     *
     * @return The connect
     */
    @JsonProperty("connect")
    public Integer getConnect() {
        return connect;
    }

    /**
     *
     * @param connect The connect
     */
    @JsonProperty("connect")
    public void setConnect(Integer connect) {
        this.connect = connect;
    }

    /**
     *
     * @return The send
     */
    @JsonProperty("send")
    public Integer getSend() {
        return send;
    }

    /**
     *
     * @param send The send
     */
    @JsonProperty("send")
    public void setSend(Integer send) {
        this.send = send;
    }

    /**
     *
     * @return The wait
     */
    @JsonProperty("wait")
    public Integer getWait() {
        return wait;
    }

    /**
     *
     * @param wait The wait
     */
    @JsonProperty("wait")
    public void setWait(Integer wait) {
        this.wait = wait;
    }

    /**
     *
     * @return The receive
     */
    @JsonProperty("receive")
    public Integer getReceive() {
        return receive;
    }

    /**
     *
     * @param receive The receive
     */
    @JsonProperty("receive")
    public void setReceive(Integer receive) {
        this.receive = receive;
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
