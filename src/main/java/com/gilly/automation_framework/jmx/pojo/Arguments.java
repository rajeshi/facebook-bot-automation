package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collectionProp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Arguments extends ElementProperty implements Serializable{

    @XmlElement(name = "elementProp")
    private final List<Argument> arguments = new ArrayList<>();
    
    public Arguments() {
        super("ArgumentsPanel", "Arguments", "User Defined Variables", true);
    }

    public Arguments(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
    }

    public Arguments(String name,String elementType){
        super(name, elementType);
    }
    
    public List<Argument> getArguments() {
        return arguments;
    }
}
