package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CookieManager extends BaseInfo implements Serializable {

    @XmlElement(name = "collectionProp")
    private CollectionProperty cookies;
    @XmlElement(name = "boolProp")
    private BoolProp clearEachIteration;
    @XmlElement(name = "stringProp")
    private StringProp policy;
    @XmlElement(name = "stringProp")
    private StringProp implementation;

    public CookieManager(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
    }

    public CookieManager() {
        super("CookiePanel", "CookieManager", "HttpCookieManager", true);
    }

    public CollectionProperty getCookies() {
        return cookies;
    }

    public void setCookies(CollectionProperty cookies) {
        this.cookies = cookies;
    }

    public BoolProp getClearEachIteration() {
        return clearEachIteration;
    }

    public void setClearEachIteration(boolean clearEachIteration) {
        this.clearEachIteration = new BoolProp();
        this.clearEachIteration.setName("CookieManager.clearEachIteration");
        this.clearEachIteration.setValue(clearEachIteration);
    }

    public StringProp getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = new StringProp();
        this.policy.setName("CookieManager.policy");
        this.policy.setValue(policy);
    }

    public StringProp getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = new StringProp();
        this.implementation.setName("CookieManager.implementation");
        this.implementation.setValue(implementation);
    }
}
