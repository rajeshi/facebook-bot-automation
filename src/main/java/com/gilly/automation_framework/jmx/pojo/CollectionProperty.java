package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "collectionProp")
public class CollectionProperty extends DataTypeProp implements Serializable {

    @XmlElement(name = "elementProp", type = ElementProperty.class)
    private final List<ElementProperty> elementProps = new ArrayList<>();

    public List<ElementProperty> getElementProps() {
        return elementProps;
    }

    public CollectionProperty() {
        setName("Arguments.arguments");
    }

}
