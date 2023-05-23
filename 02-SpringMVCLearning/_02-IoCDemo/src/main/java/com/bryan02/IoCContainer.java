package com.bryan02;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//1.实例化bean   2.保存bean    3.提供bean   4.bean与ID一一对应
public class IoCContainer {

    private final Map<String, Object> beans = new ConcurrentHashMap<>();


    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    public void setBeans(Class<?> clazz, String beanId, String... paramBeanIds) {

        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }


        /*
        这段代码是一个通过反射创建对象的示例。

        首先，代码中的`clazz`是一个`Class`对象，表示要创建对象的类。
        `getConstructors()`方法返回该类所有的公共构造方法的数组。

        然后，代码使用一个循环遍历`clazz`的所有构造方法。
        对于每个构造方法，它尝试使用`constructor.newInstance(paramValues)`创建一个新的实例。
        `paramValues`是一个参数值的数组，用于传递给构造方法。

        如果创建实例成功，就将它赋值给`bean`变量。
        如果创建实例过程中出现异常，例如无法实例化、非法访问或调用目标异常，
        那么对应的异常将被捕获，并打印异常堆栈信息，但不会中断循环继续尝试其他构造方法。

        最终，如果成功创建了一个实例，那么`bean`将引用该实例。
        如果没有找到合适的构造方法或者创建实例失败，`bean`将保持为`null`。
        */
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法实例化bean");
        }

        beans.put(beanId, bean);

    }
}
