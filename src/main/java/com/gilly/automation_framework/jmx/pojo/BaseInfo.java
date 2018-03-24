package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseInfo implements Serializable {

    @XmlAttribute(name = "guiclass")
    private String guiclass;
    @XmlAttribute(name = "testclass")
    private String testclass;
    @XmlAttribute(name = "testname")
    private String testname;
    @XmlAttribute(name = "enabled")
    private boolean enabled;

    public BaseInfo(String guiclass, String testclass, String testname, boolean enabled) {
        this.guiclass = guiclass;
        this.testclass = testclass;
        this.testname = testname;
        this.enabled = enabled;
    }

    public BaseInfo() {
    }

    public String getGuiclass() {
        return guiclass;
    }

    public void setGuiclass(String guiclass) {
        this.guiclass = guiclass;
    }

    public String getTestclass() {
        return testclass;
    }

    public void setTestclass(String testclass) {
        this.testclass = testclass;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
