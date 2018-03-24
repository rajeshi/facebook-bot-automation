package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "elementProp")
public class Argument extends ElementProperty implements Serializable {

    @XmlElement(name = "stringProp")
    private StringProp argumentName;
    @XmlElement(name = "stringProp")
    private StringProp argumentValue;
    @XmlElement(name = "stringProp")
    private StringProp argumentDesc;
    @XmlElement(name = "stringProp")
    private StringProp argumentMetadata;

    public Argument() {
        super("Argument", "Arguments.argument", "User Defined Variables", true);
    }

    public Argument(String name, String type) {
        this.name = name;
        this.elementType = type;
    }

    public StringProp getArgumentName() {
        return argumentName;
    }

    public void setArgumentName(String name) {
        this.argumentName = new StringProp();
        this.argumentName.setName("Argument.name");
        this.argumentName.setValue(name);
    }

    public StringProp getArgumentValue() {
        return argumentValue;
    }

    public void setArgumentValue(String value) {
        this.argumentValue = new StringProp();
        this.argumentValue.setName("Argument.value");
        this.argumentValue.setValue(value);
    }

    public StringProp getArgumentDesc() {
        return argumentDesc;
    }

    public void setArgumentDesc(String desc) {
        this.argumentDesc = new StringProp();
        this.argumentDesc.setName("Argument.desc");
        this.argumentDesc.setValue(desc);
    }

    public StringProp getArgumentMetadata() {
        return argumentMetadata;
    }

    public void setArgumentMetadata(String metadata) {
        this.argumentMetadata = new StringProp();
        this.argumentMetadata.setName("Argument.metadata");
        this.argumentMetadata.setValue(metadata);
    }

}
