package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "elementProp")
public class Header extends ElementProperty implements Serializable {

    @XmlElement(name = "stringProp")
    private StringProp headerValue;
    @XmlElement(name="stringProp")
    private StringProp headerName;

    public StringProp getValue() {
        return headerValue;
    }

    public void setValue(String value) {
        this.headerValue = new StringProp();
        this.headerValue.setName("Header.value");
        this.headerValue.setValue(value);
    }
    public StringProp getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = new StringProp();
        this.headerName.setName("Header.name");
        this.headerName.setValue(headerName);
    }
    

}
