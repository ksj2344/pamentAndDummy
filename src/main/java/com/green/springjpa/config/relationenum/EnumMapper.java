package com.green.springjpa.config.relationenum;

import java.util.*;

public class EnumMapper {
    private Map<String , List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public void put(String key, Class<? extends EnumMapperType> e){
        factory.put(key, toEnumValues(e));
    }

    // e.getEnumConstants(): SchoolTypeCode[] schoolTypeCodeArray
    //            = [ SchoolTypeCode.ELEMENTARY, SchoolTypeCode.MIDDLE, SchoolTypeCode.HIGH] 의 배열을 생성
    public List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e){
        return Arrays.stream(e.getEnumConstants()) //Array to Stream
                .map(EnumMapperValue::new) //같은 크기의 스트림을 만든다. 메서드 참조  .map(item-> new EnumMapperValue(item)) 와 같음
                .toList(); //최종연산
    }
    // ArrayList (EnumMapperValue 객체, EnumMapperValue 객체, EnumMapperValue 객체 )
    //첫번째 EnumMapperValue는 code="00101", value="초등학교"
    //두번째 EnumMapperValue는 code="00102", value="중학교"
    //세번째 EnumMapperValue는 code="00103", value="고등학교"
    // 최종연산은 toList니까 Stream > ArrayList로 바뀐다
    public List<EnumMapperValue> get(String key){
        return factory.get(key);
    }
}
