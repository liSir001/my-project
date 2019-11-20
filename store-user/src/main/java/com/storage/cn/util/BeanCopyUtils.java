package com.storage.cn.util;

import org.springframework.cglib.beans.BeanCopier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对象间属性复制
 * @Auther: Lei Li
 * @Date: 2019/11/20 14:39
 * @Version 1.0
 */
public class BeanCopyUtils {

    private static final Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    public static void copyProperties(Object source, Object target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, null);
    }

    public static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        return copier;
    }

    public static String generateKey(Class<?> clazz1, Class<?> clazz2) {
        return String.valueOf(clazz1) + String.valueOf(clazz2);
    }
}
