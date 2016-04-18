package kr.hkit.mybatis_dev;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.mybatis_dev.dto.Tutor;
import kr.hkit.mybatis_dev.dto.Course;
import kr.hkit.mybatis_dev.services.TutorService;

public class TutorServiceTest {
	private static TutorService tutorService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tutorService = TutorService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tutorService = null;
	}

	@Test
	public void testFindTutorById() {
		Tutor tutor = tutorService.findTutorById(1);
		Assert.assertNotNull(tutor);
		System.out.println("testFindTutorById()" + tutor);
		List<Course> courses = tutor.getCourses();
		Assert.assertNotNull(courses);
		for(Course course : courses){
			System.out.println(course);
		}
	}

}
