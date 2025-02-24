package com.green.springjpa.config.relationenum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
@Converter(autoApply = true)
public abstract class AbstractEnumCodeConverter<E extends Enum<E> & EnumMapperType>
        implements AttributeConverter<E,String> {
    private final Class<E> targetEnumClass;
    private final boolean nullable; //null 가능 여부

    //DB에 값을 Insert or update 할 때 사용
    @Override
    public String convertToDatabaseColumn(E enumItem) {
        if(!nullable && enumItem == null){ // null 허용이 아닌데 attribute가 null이면
            throw new IllegalArgumentException(String.format("%s은(는) NULL로 저장할 수 없습니다."
                    , targetEnumClass.getSimpleName()));
        }
        return EnumConvertUtils.toCode(enumItem);
    }

    //DB에서 값을 select 할 때
    @Override
    public E convertToEntityAttribute(String dbData) {
        if(!nullable && StringUtils.isBlank(dbData) || dbData == null){
            throw new IllegalArgumentException(String.format("%s은(는) DB에 NULL 혹은 Empty로 저장되어 있습니다."
                    , targetEnumClass.getSimpleName()));
        }
        return EnumConvertUtils.toCode(targetEnumClass, dbData);
    }
}
