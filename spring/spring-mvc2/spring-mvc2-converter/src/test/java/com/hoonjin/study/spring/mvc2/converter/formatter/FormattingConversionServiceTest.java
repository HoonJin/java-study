package com.hoonjin.study.spring.mvc2.converter.formatter;

import com.hoonjin.study.spring.mvc2.converter.converter.IpPortToStringConverter;
import com.hoonjin.study.spring.mvc2.converter.converter.StringToIpPortConverter;
import com.hoonjin.study.spring.mvc2.converter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionServiceTest() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        conversionService.addFormatter(new MyNumberFormatter());

        Assertions.assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class))
                .isEqualTo(new IpPort("127.0.0.1", 8080));

        Assertions.assertThat(conversionService.convert(1000, String.class))
                .isEqualTo("1,000");

        Assertions.assertThat(conversionService.convert("1,000", Long.class))
                .isEqualTo(1000L);
    }
}
