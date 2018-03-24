package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementProperty extends BaseInfo implements Serializable {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "elementType")
    protected String elementType;
    @XmlElements(value = {
        @XmlElement(name = "stringProp", type = StringProp.class
        ),
        @XmlElement(name = "boolProp", type = BoolProp.class),
        @XmlElement(name = "collectionProp", type = CollectionProperty.class),
        @XmlElement(name = "intProp", type = IntProp.class)
    })
    private final List<Object> properties = new ArrayList<>();

    public ElementProperty(String name, String elementType, String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
        this.name = name;
        this.elementType = elementType;
    }

    public ElementProperty(String name, String elementType) {
        this.name = name;
        this.elementType = elementType;
    }

    public ElementProperty(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
    }

    public ElementProperty() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getElementType() {
        return elementType;
    }

    public List<Object> getProperties() {
        return properties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }
}
