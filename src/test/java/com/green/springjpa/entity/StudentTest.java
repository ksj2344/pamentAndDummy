package com.green.springjpa.entity;

import com.green.springjpa.config.entity.Student;
import com.green.springjpa.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

//JPA Test
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentTest {
    @Autowired //TDD에서 DI 받을 때 꼭 사용해야하는 에노테이션
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void createStudent() {
        for(int i=0; i<100; i++){
            Student student = Student.builder()
                    .name(String.format("홍길동%03d", i))
                    .build();
            studentRepository.save(student);
        } //insert를 batch-size(5)만큼 한번에
        studentRepository.flush();
    }
}