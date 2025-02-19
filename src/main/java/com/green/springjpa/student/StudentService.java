package com.green.springjpa.student;

import com.green.springjpa.student.model.StudentRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Page<List<StudentRes>> getStudentList(Pageable pageable) {
        return studentRepository.findList(pageable);
    }
    //페이지타입으로 감싸서 보내면 전체 장수, 현재 장수, isMore, size 등이 넘어감. 단, 전체 장수에 대한 정보값을 얻기위해 select를 두번한다.
}
