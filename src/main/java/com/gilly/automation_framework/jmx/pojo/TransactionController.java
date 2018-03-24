package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class TransactionController extends BaseInfo implements Serializable {

    @XmlElement(name = "boolProp")
    private BoolProp parent;
    @XmlElement(name = "boolProp")
    private BoolProp includeTimers;

    public BoolProp getParent() {
        return parent;
    }

    public TransactionController(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
    }

    public TransactionController() {
        super("TransactionControllerGui", "TransactionController", "page_3", true);
    }

    public void setParent(boolean parent) {
        this.parent = new BoolProp();
        this.parent.setName("TransactionController.parent");
        this.parent.setValue(parent);
    }

    public BoolProp getIncludeTimers() {
        return includeTimers;
    }

    public void setIncludeTimers(boolean includeTimers) {
        this.includeTimers = new BoolProp();
        this.includeTimers.setName("TransactionController.includeTimers");
        this.includeTimers.setValue(includeTimers);
    }
}
