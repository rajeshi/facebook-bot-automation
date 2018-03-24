package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Jmx implements Serializable {

    @XmlElement(name = "TestPlan")
    private TestPlan testPlan;
    @XmlElement(name = "ThreadGroup")
    private final List<JThreadGroup> threadGroups = new ArrayList<>();
    @XmlElement(name = "ArgumentsPanel")
    private Arguments arguments;
    @XmlElement(name = "HeaderManager")
    private HeaderManager headers;
    @XmlElement(name = "HTTPSamplerProxy")
    private final List<HTTPSamplerProxy> samplers = new ArrayList<>();

    public TestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(TestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public List<JThreadGroup> getThreadGroups() {
        return threadGroups;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }

    public void setHeaders(HeaderManager headers) {
        this.headers = headers;
    }

    public HeaderManager getHeaders() {
        return headers;
    }

    public List<HTTPSamplerProxy> getSamplers() {
        return samplers;
    }
}
