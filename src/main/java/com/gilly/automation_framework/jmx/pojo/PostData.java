package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostData implements Serializable {

    private String mimeType;
    private final List<Argument> params = new ArrayList<>();
    private String text;

    public List<Argument> getParams() {
        return params;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
