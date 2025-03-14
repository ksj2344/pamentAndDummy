package com.green.springjpa.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
// 잭슨을 직렬화 혹은 역직렬화 하는 class
//날짜나 Long타입 객체를 직렬화 하기 위해 생성
@Configuration
public class JacksonFormatConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(@Value("${constants.jackson.date-format}") final String dateFormat
            , @Value("${constants.jackson.datetime-format}") final String dateTimeFormat) {
        return builder -> {
            builder.simpleDateFormat(dateFormat)
                    .serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)), new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)))
                    .serializerByType(Long.class, ToStringSerializer.instance) //Long to String
//                 .deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern(dateFormat))
//                              , new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat))
//                 )
            ;
        };
    }
}