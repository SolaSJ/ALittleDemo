package com.sola.alittledemo.util;

/**
 * 类属性转换字段过滤器
 * @author chao.lan@karakal.com.cn (兰超)
 * @version 1.0
 * @Date 2018/10/30 15: 41
 * Copyright (c) 2018, 北京卡拉卡尔科技股份有限公司 All rights reserved.
 */
public class CovertBeanFilter {
//     implements
// } FieldFilter {
    /**
     * 获取匹配后的字段映射关系
     * @param srcObj 原对象
     * @param targetObj 目标对象
     * @param <K>
     * @return
     */
  /*  @Override
    public <K,V> HashMap<Field, Field> getMatchedFields(K srcObj, V targetObj) {
        HashMap<Field, Field> result = new HashMap<>();
        Class<?> srcClazz = srcObj.getClass();
        Field[] srcFields = srcClazz.getDeclaredFields();
        Class<?> targetClazz = targetObj.getClass();
        Field[] targetFields = targetClazz.getDeclaredFields();
        HashMap<String, Field> srcNickFiledName = getNickFiledNameMap(srcFields);
        HashMap<String, Field> targetNickFiledName = getNickFiledNameMap(targetFields);
        for(String key : srcNickFiledName.keySet()){
            Field targetValue = targetNickFiledName.get(key);
            if(targetValue != null){
                result.put(srcNickFiledName.get(key),targetValue);
            }
        }
        return result;
    }

    *//**
     * 获取自定义注解名称和原始字段名的映射关系
     * （自定义注解名不可重复）
     * @param fields
     * @return
     *//*
    private HashMap<String,Field> getNickFiledNameMap(Field[] fields){
        HashMap<String,Field> map = new HashMap<>();
        for (Field field : fields) {
            String filedName = field.getName();
            CopyPropertyAnnotation myAnnotation = field.getAnnotation(CopyPropertyAnnotation.class);
            if(myAnnotation == null){
                map.put(filedName,field);
            }else if (myAnnotation.copy()){
                String nickFieldName = myAnnotation.nickFieldName();
                //优先采用注解字段名
                if(StringUtils.isNotEmpty(nickFieldName)) {
                    //注解字段名不能重复
                    if (map.containsKey(nickFieldName)) {
                        throw new RuntimeException("CopyPropertyAnnotation.clazz's nickFieldName has been duplication!");
                    }
                    map.put(nickFieldName, field);
                }else{
                    map.put(filedName,field);
                }
            }else {
                //不转换字段直接跳过
                continue;
            }
        }
        return map;
    }*/
}
