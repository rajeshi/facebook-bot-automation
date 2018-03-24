package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;

public class Config extends BaseInfo implements Serializable {
    
    public Config(String guiclass, String testclass, String testname, boolean enabled) {
        super(guiclass, testclass, testname, enabled);
    }
    
}
