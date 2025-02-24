package com.green.springjpa.entity;

import com.green.springjpa.config.relationenum.AbstractEnumCodeConverter;
import com.green.springjpa.config.relationenum.EnumMapperType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum SchoolTypeCode implements EnumMapperType {

    ELEMENTARY("00101", "초등학교")
    , MIDDLE("00102", "중학교")
    , HIGH("00103", "고등학교")
    ;

    private final String code;
    private final String value;

    @Converter(autoApply = true) //SchoolTypeCode Enum을 사용하는 Entity는 자동으로 컨버터가 작동하도록 하는 에노테이션.
    // 저장될 때 1, 2, 3이 아니라 00101, 00102, 00103으로 저장된다는 말
    public static class CodeConverter extends AbstractEnumCodeConverter<SchoolTypeCode> {
        public CodeConverter() {
            super(SchoolTypeCode.class, false);
        }
    }
}