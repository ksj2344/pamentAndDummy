package com.green.springjpa.config.relationenum;

import com.fasterxml.jackson.annotation.JsonValue;

public interface EnumMapperType {
    String getCode();
    @JsonValue // enum으로 작성한 데이터가 key값이 아닌 value 값으로 출력되게 만들어줌
    String getValue();
}