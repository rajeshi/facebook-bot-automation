package com.gilly.automation_framework.jmx.pojo;

public enum ElementType {

    ARGUMENTS("Arguments"),
    ARGUMENT("Argument"),
    HEADER("Header"),
    HTTP_ARGUMENTS("HTTPArgument");

    private final String name;

    ElementType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
