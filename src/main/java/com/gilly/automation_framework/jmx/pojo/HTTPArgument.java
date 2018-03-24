package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "elementProp")
public class HTTPArgument extends Argument implements Serializable {

    @XmlElement(name = "boolProp")
    private BoolProp use_equals;
    @XmlElement(name = "boolProp")
    private BoolProp always_encode;

    public BoolProp isUse_equals() {
        return use_equals;
    }

    public void setUse_equals(boolean use_equals) {
        this.use_equals = new BoolProp();
        this.use_equals.setName("HTTPArgument.use_equals");
        this.use_equals.setValue(use_equals);
    }

    public BoolProp isAlways_encode() {
        return always_encode;
    }

    public void setAlways_encode(boolean always_encode) {
        this.always_encode = new BoolProp();
        this.always_encode.setName("HTTPArgument.always_encode");
        this.always_encode.setValue(always_encode);
    }

}
