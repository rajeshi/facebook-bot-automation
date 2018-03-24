package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CacheManager extends BaseInfo implements Serializable {

    @XmlElement(name = "boolProp")
    private BoolProp clearEachIteration;
    @XmlElement(name = "boolProp")
    private BoolProp useExpires;

    public BoolProp getClearEachIteration() {
        return clearEachIteration;
    }

    public void setClearEachIteration(boolean clearEachIteration) {
        this.clearEachIteration = new BoolProp();
        this.clearEachIteration.setName("clearEachIteration");
        this.clearEachIteration.setValue(clearEachIteration);
    }

    public BoolProp getUseExpires() {
        return useExpires;
    }

    public void setUseExpires(boolean useExpires) {
        this.useExpires = new BoolProp();
        this.useExpires.setName("useExpires");
        this.useExpires.setValue(useExpires);
    }

    public CacheManager(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
    }

    public CacheManager() {
        super("CacheManagerGui", "CacheManager", "HttpCacheManager", true);
    }

}
