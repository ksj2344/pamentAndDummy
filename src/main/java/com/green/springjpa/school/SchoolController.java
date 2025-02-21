package com.green.springjpa.school;

import com.green.springjpa.school.model.SchoolGetRes;
import com.green.springjpa.school.model.SchoolPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("school")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<SchoolGetRes> getAll() {
        return schoolService.getAll();
    }

    @PostMapping
    public void save(@RequestBody SchoolPostReq req) {
        log.info("req: {}", req);
        schoolService.save(req);
    }
}