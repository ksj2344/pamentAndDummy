package com.green.springjpa.config.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends UpdatedAt{
    @Id @Tsid  //Tsid는 UUID와 autoIncrement의 대체용으로 생성시간순으로 정렬 가능하다
    private Long studentId;

    @Column(nullable = false)
    private String name;
}
