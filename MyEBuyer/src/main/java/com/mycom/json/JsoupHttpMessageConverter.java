package com.mycom.json;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 */
public class JsoupHttpMessageConverter extends MappingJackson2HttpMessageConverter {
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        if (object instanceof JSONPObject) {
            JSONPObject jsonp = (JSONPObject) object;
            OutputStream out = outputMessage.getBody();
            String text = jsonp.getFunction() + "(" + this.objectMapper.writeValueAsString(jsonp.getJson()) + ")";
            byte[] bytes = text.getBytes(outputMessage.getHeaders().getContentType().getCharSet());//使用contentType中的编码
            out.write(bytes);
        } else {
            super.writeInternal(object, outputMessage);
        }

    }
}
