package com.killbug.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 封装的流式操作集合方法类
 * @author Zch
 * @date 2023/8/19
 **/
public class StreamUtils {

    /**
     * 过滤集合中的元素，根据指定的条件(Predicate)函数进行筛选，并返回筛选后的结果列表
     * @param collection
     * @param function
     * @return
     * @param <E>
     */
    public static <E> List<E> filter(Collection<E> collection, Predicate<E> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection.stream().filter(function).collect(Collectors.toList());
    }

    /**
     * 将集合中的元素转换为字符串，并使用指定的分隔符进行连接。
     * 可以指定一个转换函数(Function)来定义元素到字符串的转换方式
     * @param collection
     * @param function
     * @return
     * @param <E>
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function) {
        return join(collection, function, ",");
    }

    public static <E> String join(Collection<E> collection, Function<E, String> function, CharSequence delimiter) {
        if (CollUtil.isEmpty(collection)) {
            return StrUtil.EMPTY;
        }
        return collection.stream().map(function).filter(Objects::nonNull).collect(Collectors.joining(delimiter));
    }

    /**
     * 对集合中的元素进行排序，并返回排序后的结果列表。
     * 需要提供一个比较器(Comparator)来定义元素的排序规则
     * @param collection
     * @param comparing
     * @return
     * @param <E>
     */
    public static <E> List<E> sorted(Collection<E> collection, Comparator<E> comparing) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection.stream().sorted(comparing).collect(Collectors.toList());
    }

    /**
     * 将集合中的元素转换为具有唯一键的映射表(Map，键和值类型可以不同)，并返回结果映射表。
     * 需要提供一个键(Function)来定义元素到键的转换方式
     * @param collection
     * @param key
     * @return
     * @param <V>
     * @param <K>
     */
    public static <V, K> Map<K, V> toIdentityMap(Collection<V> collection, Function<V, K> key) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection.stream().collect(Collectors.toMap(key, Function.identity(), (l, r) -> l));
    }

    /**
     * 将集合中的元素转换为映射表(Map)，并返回结果映射表。需要提供两个转换函数，一个用于元素到键的转换，一个用于元素到值的转换
     * @param collection
     * @param key
     * @param value
     * @return
     * @param <E>
     * @param <K>
     * @param <V>
     */
    public static <E, K, V> Map<K, V> toMap(Collection<E> collection, Function<E, K> key, Function<E, V> value) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection.stream().collect(Collectors.toMap(key, value, (l, r) -> l));
    }

    /**
     * 根据指定的键对集合中的元素进行分组，并返回结果映射表，其中键是分组的键，值是对应键的元素列表
     * @param collection
     * @param key
     * @return
     * @param <E>
     * @param <K>
     */
    public static <E, K> Map<K, List<E>> groupByKey(Collection<E> collection, Function<E, K> key) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream()
                .collect(Collectors.groupingBy(key, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * 根据两个指定的键对集合中的元素进行分组，并返回结果嵌套映射表，
     * 其中第一级键是第一个键的分组，第二级键是第二个键的分组，值是对应键的元素列表
     * @param collection
     * @param key1
     * @param key2
     * @return
     * @param <E>
     * @param <K>
     * @param <U>
     */
    public static <E, K, U> Map<K, Map<U, List<E>>> groupBy2Key(Collection<E> collection, Function<E, K> key1, Function<E, U> key2) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream()
                .collect(Collectors.groupingBy(key1, LinkedHashMap::new, Collectors.groupingBy(key2, LinkedHashMap::new, Collectors.toList())));
    }

    /**
     * 根据两个指定的键将集合中的元素转换为映射表，并返回结果嵌套映射表，
     * 其中第一级键是第一个键的值，第二级键是第二个键的值，值是对应元素
     * @param collection
     * @param key1
     * @param key2
     * @return
     * @param <E>
     * @param <T>
     * @param <U>
     */
    public static <E, T, U> Map<T, Map<U, E>> group2Map(Collection<E> collection, Function<E, T> key1, Function<E, U> key2) {
        if (CollUtil.isEmpty(collection) || key1 == null || key2 == null) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream()
                .collect(Collectors.groupingBy(key1, LinkedHashMap::new, Collectors.toMap(key2, Function.identity(), (l, r) -> l)));
    }

    /**
     * 根据两个指定的键将集合中的元素转换为映射表，并返回结果嵌套映射表，
     * 其中第一级键是第一个键的值，第二级键是第二个键的值，值是对应元素
     * @param collection
     * @param function
     * @return
     * @param <E>
     * @param <T>
     */
    public static <E, T> List<T> toList(Collection<E> collection, Function<E, T> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 将集合中的元素转换为集合，并返回结果集合。可以提供一个转换函数来定义元素到目标类型的转换方式
     * @param collection
     * @param function
     * @return
     * @param <E>
     * @param <T>
     */
    public static <E, T> Set<T> toSet(Collection<E> collection, Function<E, T> function) {
        if (CollUtil.isEmpty(collection) || function == null) {
            return CollUtil.newHashSet();
        }
        return collection
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    /**
     * 将两个映射表按照指定的合并函数进行合并，并返回合并后的映射表。
     * 合并函数接受两个值作为输入，并返回合并后的值
     * @param map1
     * @param map2
     * @param merge
     * @return
     * @param <K>
     * @param <X>
     * @param <Y>
     * @param <V>
     */
    public static <K, X, Y, V> Map<K, V> merge(Map<K, X> map1, Map<K, Y> map2, BiFunction<X, Y, V> merge) {
        if (MapUtil.isEmpty(map1) && MapUtil.isEmpty(map2)) {
            return MapUtil.newHashMap();
        } else if (MapUtil.isEmpty(map1)) {
            map1 = MapUtil.newHashMap();
        } else if (MapUtil.isEmpty(map2)) {
            map2 = MapUtil.newHashMap();
        }
        Set<K> key = new HashSet<>();
        key.addAll(map1.keySet());
        key.addAll(map2.keySet());
        Map<K, V> map = new HashMap<>();
        for (K t : key) {
            X x = map1.get(t);
            Y y = map2.get(t);
            V z = merge.apply(x, y);
            if (z != null) {
                map.put(t, z);
            }
        }
        return map;
    }
}
