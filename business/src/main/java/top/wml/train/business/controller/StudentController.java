package top.wml.train.business.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wml.train.business.domain.Student;
import top.wml.train.business.domain.StudentExample;
import top.wml.train.business.mapper.StudentMapper;
import top.wml.train.common.resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @GetMapping("/getByName")
    public CommonResp<List<Student>> getByName(@RequestParam String name){
        StudentExample example = new StudentExample();
        example.createCriteria().andNameLike(name + "%");
        return new CommonResp<>(studentMapper.selectByExample(example));
    }
}
