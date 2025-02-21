package com.green.springjpa.config.relationenum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)// private 기본 생성자,  객체 생성 불가능하게 설정
//static 메소드 or 부모 메소드 역할에 사용
public class EnumConvertUtils {

    //extends를 통해 ENUM과 EnumMapperType을 상속받은 타입만 리턴할 수 있도록
    // ENUM class와 value를 보내면 enum Item을 리턴하도록
    // ex) enumClass: SchoolTypeCode.class, value: "00102" >> SchoolTypeCode.MIDDLE 타입이 리턴
    public static <E extends Enum<E> & EnumMapperType> E toCode(Class<E> enumClass, String code){
        if(StringUtils.isBlank(code)){return null;} //StringUtils.isBlank(value): value가 null이거나 빈문자열이거나 "  "이라면
        return EnumSet.allOf(enumClass) // (1) Enum이 가진 모든 아이템들을 가진 콜렉션 리턴
                .stream() // (2) (1)을 스트림 생성
                .filter(item->item.getCode().equals(code)) // (3) 스트림 아이템 중에 원하는 아이템만 다시 스트림 생성
                //filter은 predicate 타입. predicate: 파라미터가 있고 boolean타입으로 리턴
                .findFirst() //(4) (3)의 스트림 아이템 중 첫번째 아이템을 리턴(Optional)
                .orElse(null); // (5) (4)가 null이라면 null 리턴
    }


    // enumItem을 보내면 value를 리던하도록
    // ex) SchoolTypeCode.MIDDLE이 들어오면 '00102' 리턴
    public static <E extends Enum<E> & EnumMapperType> String toCode(E enumItem){
        if(enumItem == null){return null;}
        return enumItem.getCode();
    }

}
