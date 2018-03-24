package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class HTTPArguments extends Arguments implements Serializable {

    @XmlElement(name = "collectionProp")
    private CollectionProperty httpArguments;

    public HTTPArguments(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
        setName("HTTPsampler.Arguments");
        setElementType("Arguments");
    }

    public HTTPArguments() {
        setName("HTTPsampler.Arguments");
        setElementType("Arguments");
    }

    public HTTPArguments(String name, String elementType) {
        super(name, elementType);
    }

    public CollectionProperty getHttpArguments() {
        return httpArguments;
    }

    public void setHttpArguments(CollectionProperty httpArguments) {
        this.httpArguments = httpArguments;
    }
}
