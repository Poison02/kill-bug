package com.killbug.common.core.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.SimpleCache;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.core.Converter;

import java.util.List;
import java.util.Map;

/**
 * 封装的用于对象copy和转换的工具类
 * @author Zch
 * @date 2023/8/19
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanCopyUtils {

    /**
     * 将一个对象的属性值复制到另一个对象，并返回目标对象。
     * 该方法根据源对象和目标对象的属性名称和类型进行属性值的拷贝。如果源对象或目标对象为空，则返回null
     * @param source
     * @param desc
     * @return
     * @param <T>
     * @param <V>
     */
    public static <T, V> V copy(T source, Class<V> desc) {
        if (ObjectUtil.isNull(source)) {
            return null;
        }
        if (ObjectUtil.isNull(desc)) {
            return null;
        }
        final V target = ReflectUtil.newInstance(desc);
        return copy(source, target);
    }

    public static <T, V> V copy(T source, V desc) {
        if (ObjectUtil.isNull(source)) {
            return null;
        }
        if (ObjectUtil.isNull(desc)) {
            return null;
        }
        BeanCopier beanCopier = BeanCopierCache.INSTANCE.get(source.getClass(), desc.getClass(), null);
        beanCopier.copy(source, desc, null);
        return desc;
    }

    /**
     * 将一个源对象列表的属性值复制到目标对象列表，并返回目标对象列表。
     * 该方法使用StreamUtils.toList将源对象列表转换为目标对象列表，
     * 并在转换过程中进行属性值的拷贝
     * @param sourceList
     * @param desc
     * @return
     * @param <T>
     * @param <V>
     */
    public static <T, V> List<V> copyList(List<T> sourceList, Class<V> desc) {
        if (ObjectUtil.isNull(sourceList)) {
            return null;
        }
        if (CollUtil.isEmpty(sourceList)) {
            return CollUtil.newArrayList();
        }
        return StreamUtils.toList(sourceList, source -> {
            V target = ReflectUtil.newInstanceIfPossible(desc);
            copy(source, target);
            return target;
        });
    }

    /**
     * 将一个对象的属性值复制到一个键值对映射表，并返回映射表。
     * 该方法使用BeanMap.create将对象转换为键值对的映射表
     * @param bean
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> copyToMap(T bean) {
        if (ObjectUtil.isNull(bean)) {
            return null;
        }
        return BeanMap.create(bean);
    }

    /**
     * 将一个键值对映射表的值复制到一个对象，并返回对象。
     * 该方法使用BeanMap.create(bean).putAll(map)将键值对映射表的值复制到对象的属性中
     * @param map
     * @param beanClass
     * @return
     * @param <T>
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) {
        if (MapUtil.isEmpty(map)) {
            return null;
        }
        if (ObjectUtil.isNull(beanClass)) {
            return null;
        }
        T bean = ReflectUtil.newInstanceIfPossible(beanClass);
        return mapToBean(map, bean);
    }

    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        if (MapUtil.isEmpty(map)) {
            return null;
        }
        if (ObjectUtil.isNull(bean)) {
            return null;
        }
        BeanMap.create(bean).putAll(map);
        return bean;
    }

    /**
     * 这是一个枚举类型，表示BeanCopier的缓存。BeanCopier是一个用于对象属性拷贝的工具类，
     * 它使用BeanCopier.create方法创建一个BeanCopier对象，并使用SimpleCache进行缓存
     */
    public enum BeanCopierCache {

        INSTANCE;

        private final SimpleCache<String, BeanCopier> cache = new SimpleCache<>();

        public BeanCopier get(Class<?> srcClass, Class<?> targetClass, Converter converter) {
            final String key = genKey(srcClass, targetClass, converter);
            return cache.get(key, () -> BeanCopier.create(srcClass, targetClass, converter != null));
        }

        private String genKey(Class<?> srcClass, Class<?> targetClass, Converter converter) {
            final StringBuilder key = StrUtil.builder()
                    .append(srcClass.getName()).append('#').append(targetClass.getName());
            if(null != converter){
                key.append('#').append(converter.getClass().getName());
            }
            return key.toString();
        }
    }

}
