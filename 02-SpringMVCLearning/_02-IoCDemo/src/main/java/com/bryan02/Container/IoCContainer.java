package com.bryan02.Container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IoCContainer {
    private Map<String, Object> beans = new ConcurrentHashMap<>();

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    public void setBeans(Class<?> clazz, String beanId, String... paramBeanIds) {

    }
}
