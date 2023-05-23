package com.bryan02.three;

import java.util.List;

public class Bean {
    private AnotherBean anotherBean;
    private String string;

    private AnotherBean anotherBean1;
    private String string1;
    private List<String> stringList;
    private List<AnotherBean> anotherBeanList;

    public Bean() {}

    public Bean(AnotherBean anotherBean, String string) {
        this.anotherBean = anotherBean;
        this.string = string;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public void setString(String string) {
        this.string = string;
    }

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "anotherBean=" + anotherBean +
                ", string='" + string + '\'' +
                '}';
    }
}
