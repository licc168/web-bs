package com.licc.common.util;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合工具类
 */
public class Collection3 {
    /**
     * LIST 对象转化成String
     * @param list 目标对象
     * @param clumName  对象里面的字段名称
     * @param separator 分隔符
     * @return
     */
    public static <T> String transListToString(List<T> list, final String clumName, String separator) {
        if(CollectionUtils.isEmpty(list))return "";
        Function<Object, String> trans = new Function<Object, String>() {
            @Override
            public String apply(Object obj) {
                String s = "";
                try {
                    s = BeanUtils.getProperty(obj, clumName);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
                return s;
            }
        };
        return Joiner.on(separator).join(Lists.transform(list, trans));
    }



    /**
     * String 转 List<T>
     * @param target
     * @param separator
     * @param <T>
     * @return
     */
    public static <T>  List<T> transStringToList(String target , String separator){
        if(StringUtils.isEmpty(target)) return  Collections.EMPTY_LIST;
        List<T> retList = new ArrayList<>();
        List<String> list = Splitter.on(separator).trimResults().splitToList(target );
        for(String s:list){
            retList.add((T) s);
        }
        return CollectionUtils.isEmpty(retList)?Collections.EMPTY_LIST:retList;

    }

}
