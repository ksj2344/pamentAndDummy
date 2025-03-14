package com.green.springjpa.entity;

import com.green.springjpa.config.relationenum.AbstractEnumCodeConverter;
import com.green.springjpa.config.relationenum.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public enum StudentGradeTypeCode implements EnumMapperType {
    GRADE_1("00201","1학년")
    ,GRADE_2("00202", "2학년")
    ,GRADE_3("00203", "3학년")
    ;

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<StudentGradeTypeCode> {
        public CodeConverter() {
            super(StudentGradeTypeCode.class, false);
        }
    }
}
