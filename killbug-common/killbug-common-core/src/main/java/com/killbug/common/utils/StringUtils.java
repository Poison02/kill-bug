package com.killbug.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串工具类
 * @author Zch
 * @date 2023/8/19
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 将空白字符串转换为默认值。如果输入字符串为空或仅包含空白字符，则返回默认值
     * @param str
     * @param defaultValue
     * @return
     */
    public static String blankToDefault(String str, String defaultValue) {
        return StrUtil.blankToDefault(str, defaultValue);
    }

    /**
     * 判断字符串是否为空。如果字符串为null或长度为0，则返回true
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return StrUtil.isEmpty(str);
    }

    /**
     * 判断字符串是否非空。如果字符串不为null且长度大于0，则返回true
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 去除字符串两端的空白字符
     * @param str
     * @return
     */
    public static String trim(String str) {
        return StrUtil.trim(str);
    }

    /**
     *  截取字符串中从指定位置开始到字符串结尾的子串
     * @param str
     * @param start
     * @return
     */
    public static String substring(final String str, int start) {
        return substring(str, start, str.length());
    }

    /**
     * 截取字符串中从指定起始位置到指定结束位置的子串
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String substring(final String str, int start, int end) {
        return StrUtil.sub(str, start, end);
    }

    /**
     * 格式化字符串。使用占位符将参数填充到字符串模板中。
     * @param template
     * @param params
     * @return
     */
    public static String format(String template, Object... params) {
        return StrUtil.format(template, params);
    }

    /**
     * 判断字符串是否为合法的URL地址
     * @param link
     * @return
     */
    public static boolean ishttp(String link) {
        return Validator.isUrl(link);
    }

    /**
     * 将字符串按指定分隔符拆分成Set集合
     * @param str
     * @param sep
     * @return
     */
    public static Set<String> str2Set(String str, String sep) {
        return new HashSet<>(str2List(str, sep, true, false));
    }

    /**
     * 将字符串按指定分隔符拆分成List列表。可以选择过滤空白字符串和去除每个元素的前后空白字符
     * @param str
     * @param sep
     * @param filterBlank
     * @param trim
     * @return
     */
    public static List<String> str2List(String str, String sep, boolean filterBlank, boolean trim) {
        List<String> list = new ArrayList<>();
        if (isEmpty(str)) {
            return list;
        }

        // 过滤空白字符串
        if (filterBlank && isBlank(str)) {
            return list;
        }
        String[] split = str.split(sep);
        for (String string : split) {
            if (filterBlank && isBlank(string)) {
                continue;
            }
            if (trim) {
                string = trim(string);
            }
            list.add(string);
        }

        return list;
    }

    /**
     * 判断字符串是否包含任意一个指定的子串，忽略大小写
     * @param cs
     * @param searchCharSequences
     * @return
     */
    public static boolean containsAnyIgnoreCase(CharSequence cs, CharSequence... searchCharSequences) {
        return StrUtil.containsAnyIgnoreCase(cs, searchCharSequences);
    }

    /**
     * 将驼峰命名转换为下划线命名
     * @param str
     * @return
     */
    public static String toUnderScoreCase(String str) {
        return StrUtil.toUnderlineCase(str);
    }

    /**
     * 判断字符串是否在指定的字符串数组中出现，忽略大小写
     * @param str
     * @param strs
     * @return
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        return StrUtil.equalsAnyIgnoreCase(str, strs);
    }

    /**
     * 将字符串转换为驼峰命名
     * @param name
     * @return
     */
    public static String convertToCamelCase(String name) {
        return StrUtil.upperFirst(StrUtil.toCamelCase(name));
    }

    /**
     * 将字符串转换为驼峰命名
     * @param s
     * @return
     */
    public static String toCamelCase(String s) {
        return StrUtil.toCamelCase(s);
    }

    /**
     * 判断字符串与给定的模式列表中的任意一个是否匹配
     * @param str
     * @param strs
     * @return
     */
    public static boolean matches(String str, List<String> strs) {
        if (isEmpty(str) || CollUtil.isEmpty(strs)) {
            return false;
        }
        for (String pattern : strs) {
            if (isMatch(pattern, str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串与指定的模式是否匹配。模式可以使用通配符
     * @param pattern
     * @param url
     * @return
     */
    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    /**
     * 在字符串左侧填充指定字符，使字符串达到指定长度。
     * @param num
     * @param size
     * @return
     */
    public static final String padl(final Number num, final int size) {
        return padl(num.toString(), size, '0');
    }

    /**
     * 在字符串左侧填充指定字符，使字符串达到指定长度。
     * @param s
     * @param size
     * @param c
     * @return
     */
    public static final String padl(final String s, final int size, final char c) {
        final StringBuilder sb = new StringBuilder(size);
        if (s != null) {
            final int len = s.length();
            if (s.length() <= size) {
                for (int i = size - len; i > 0; i--) {
                    sb.append(c);
                }
                sb.append(s);
            } else {
                return s.substring(len - size, len);
            }
        } else {
            for (int i = size; i > 0; i--) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
