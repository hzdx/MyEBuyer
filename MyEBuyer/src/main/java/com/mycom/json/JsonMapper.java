package com.mycom.json;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

@Component
public class JsonMapper extends ObjectMapper{
    public JsonMapper(){
        super();
        //json转换配置，增加容错
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        this.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, true);

        //this.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //这个设置了,为空的字段不会序列化

        this.configure(MapperFeature.AUTO_DETECT_CREATORS, true);
        this.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
        this.configure(MapperFeature.AUTO_DETECT_SETTERS, true);
        this.configure(MapperFeature.AUTO_DETECT_GETTERS,true);

        //启用注解
        this.configure(MapperFeature.USE_ANNOTATIONS,true);


    }
}
