package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JmeterTestPlan implements Serializable {

    @XmlAttribute(name = "version")
    private final String version = "1.2";
    @XmlAttribute(name = "properties")
    private final String properties = "2.8";
    @XmlAttribute(name = "jmeter")
    private final String jmeter = "2.13";
    @XmlAttribute(name = "ruby-jmeter")
    private final String ruby_jmeter = "2.13.0";
    @XmlElement(name = "hashTree")
    private final List<HashTree> hashTree = new ArrayList<>();

    public JmeterTestPlan() {
    }

    public String getRuby_jmeter() {
        return ruby_jmeter;
    }

    public String getVersion() {
        return version;
    }

    public String getProperties() {
        return properties;
    }

    public String getJmeter() {
        return jmeter;
    }

    public List<HashTree> getHashTree() {
        return hashTree;
    }
}
