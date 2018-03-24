package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class HashTree implements Serializable {

    @XmlElements(value
            = {
                @XmlElement(name = "TestPlan", type = TestPlan.class, namespace = ""),
                @XmlElement(name = "HeaderManager", type = HeaderManager.class, namespace = ""),
                @XmlElement(name = "ThreadGroup", type = JThreadGroup.class, namespace = ""),
                @XmlElement(name = "HTTPSamplerProxy", type = HTTPSamplerProxy.class, namespace = ""),
                @XmlElement(name = "hashTree", type = HashTree.class),
                @XmlElement(name="CacheManager",type = CacheManager.class),
                @XmlElement(name="CookieManager",type = CookieManager.class),
                @XmlElement(name="TransactionController",type = TransactionController.class)
            })
    private final List<Object> jElements = new ArrayList<>();

    public List<Object> getjElements() {
        return jElements;
    }

}
