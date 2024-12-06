package com.hoonjin.study.spring.mvc2.converter.converter;

import com.hoonjin.study.spring.mvc2.converter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(IpPort source) {
        return source.getIp() + ":" + source.getPort();
    }
}
