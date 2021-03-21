package org.miact.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author miact
 */
public class CreateFactory {

    private static Map<String,Object> beanMap = new HashMap<>();

    private static Properties properties;

    static {
        properties = new Properties();
        try{
            properties.load(CreateFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        }catch (IOException e){
            throw new ExceptionInInitializerError("BeanFactory initialize error,cause: "+ e.getMessage());
        }
    }

    public static Object getBean(String beanName){
        if (!beanMap.containsKey(beanName)){
            synchronized (CreateFactory.class){
                if (!beanMap.containsKey(beanName)) {
                    try {
                        Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
                        Object bean = beanClazz.newInstance();
                        beanMap.put(beanName,bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
                    } catch (IllegalAccessException | InstantiationException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    }
                }
            }
        }
        return beanMap.get(beanName);
    }

}
