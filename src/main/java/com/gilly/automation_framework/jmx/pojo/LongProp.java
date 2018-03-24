package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "longProp")
@XmlAccessorType(XmlAccessType.FIELD)
public class LongProp extends DataTypeProp implements Serializable {

    @XmlValue
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
