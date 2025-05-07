package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired // 타입을 베이스로 bean을 찾아온다.
	Course course; //Course 타입인게 하나밖에 없어서 퀄리파이로 지정해 주지 않아도 됨
	
	@Resource(name = "gradeService") // 이름을 기준으로 찾기 때문에 name 반드시!
	GradeService service;
	
	@Test
	void testService() {
		assertNotNull(service);
		assertEquals("C001", service.getCourse().getCourseId());
		assertEquals("A", service.calculateGrade("S001"));
		assertEquals(2, service.getHighScoreStudents(80).size());
		
		for(Student student : service.getHighScoreStudents(80)) {
			System.out.println(student);
		}
	}
	
	@Test @Disabled
	void testCourse() {
		assertNotNull(course);
		assertEquals("Java Programming", course.getCourseName());
		assertEquals(3, course.getStudents().size());
		/*
		 *  course.getStudents() => List<Student>
		 *  course.getStudents().get(0)
		 *  course.getStudents().get(0)
		 */
		assertEquals("엠마", course.getStudents().get(0).getName());
		
		System.out.println(course.getAverageScore());
		assertEquals(83.333, course.getAverageScore(), 0.001);
	}
}
