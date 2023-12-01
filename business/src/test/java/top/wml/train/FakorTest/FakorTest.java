package top.wml.train.FakorTest;

import com.github.javafaker.Faker;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wml.train.business.config.BusinessApplication;
import top.wml.train.business.domain.Student;
import top.wml.train.business.mapper.StudentMapper;

import java.util.Locale;

@SpringBootTest(classes = BusinessApplication.class)
public class FakorTest {

    @Resource
    private StudentMapper studentMapper;
    @Test
    void Test(){
        for (int i = 0; i < 100000; i++) {
            Faker faker = new Faker(Locale.CHINA);
            String name = faker.name().fullName();
            String mobile = faker.phoneNumber().cellPhone();
            int age = faker.number().numberBetween(1, 50);
            String school = faker.university().name();
            String email = faker.internet().emailAddress();
            Student student = new Student();
            student.setName(name);
            student.setMobile(mobile);
            student.setAge(age);
            student.setSchool(school);
            student.setEmail(email);
            studentMapper.insert(student);
        }

    }

}
