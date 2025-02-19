package com.green.springjpa.student.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class StudentRes {
    private Long studentId;
    private String name;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //JSON으로 변환될 때 이 형태로 만들겠다.
    private LocalDateTime createdAt;
    //그러나? 실수할 수 있기 때문에 LocalDateTime 타입에 대한 설정을 yml에 한다.
    //그리고 JacksonFormatConfiguration에 설정.

    public StudentRes(Long studentId, String name, LocalDateTime createdAt) {
        this.studentId = studentId;
        this.name = name;
        this.createdAt = createdAt;

    }
}
