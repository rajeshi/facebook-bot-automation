package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TestPlan extends BaseInfo implements Serializable {

    @XmlElement(name = "stringProp")
    private StringProp comments;
    @XmlElement(name = "boolProp")
    private BoolProp functional_mode;
    @XmlElement(name = "boolProp")
    private BoolProp serialize_threadgroups;
    @XmlElement(name = "elementProp")
    private ElementProperty user_defined_variables;
    @XmlElement(name = "stringProp")
    private StringProp user_define_classpath;

    public ElementProperty getUser_defined_variables() {
        return user_defined_variables;
    }

    public void setUser_defined_variables(ElementProperty user_defined_variables) {
        this.user_defined_variables = user_defined_variables;
    }

    public TestPlan() {
        super("TestPlanGui", "TestPlan", "TestPlan", true);
        setComments("");
        this.user_define_classpath = new StringProp();
        this.user_define_classpath.setName("TestPlan.user_define_classpath");
        this.functional_mode = new BoolProp();
        this.functional_mode.setName("TestPlan.functional_mode");
        this.functional_mode.setValue(false);
        this.serialize_threadgroups = new BoolProp();
        this.serialize_threadgroups.setName("TestPlan.serialize_threadgroups");
        this.serialize_threadgroups.setValue(false);
    }

    public BoolProp getFunctional_mode() {
        return functional_mode;
    }

    public void setFunctional_mode(BoolProp functional_mode) {
        this.functional_mode = functional_mode;
    }

    public BoolProp getSerialize_threadgroups() {
        return serialize_threadgroups;
    }

    public void setSerialize_threadgroups(BoolProp serialize_threadgroups) {
        this.serialize_threadgroups = serialize_threadgroups;
    }

    public StringProp getUser_define_classpath() {
        return user_define_classpath;
    }

    public void setUser_define_classpath(StringProp user_define_classpath) {
        this.user_define_classpath = user_define_classpath;
    }

    public StringProp getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = new StringProp();
        this.comments.setName("TestPlan.comments");
        this.comments.setValue(comments);
    }
}
