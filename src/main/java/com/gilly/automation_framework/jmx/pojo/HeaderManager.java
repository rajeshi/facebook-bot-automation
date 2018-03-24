package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class HeaderManager extends BaseInfo implements Serializable {

    @XmlElement(name = "collectionProp")
    private CollectionProperty headers;

    public HeaderManager() {
        super("HeaderPanel", "HeaderManager", "HttpHeaderManager", true);
    }

    public CollectionProperty getHeaders() {
        return headers;
    }

    public void setHeaders(CollectionProperty headers) {
        this.headers = headers;
    }    
}
