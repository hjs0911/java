package kr.hkit.mybatis_dev;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.mybatis_dev.dto.Course;
import kr.hkit.mybatis_dev.services.CourseService;

public class CourseServiceTest {
	private static CourseService courseService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseService = CourseService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseService = null;
	}

	/*
	 * @Test public void testSearchCourses() { GregorianCalendar cal = new
	 * GregorianCalendar(2013, 1, 1);
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map.put("tutorId", 1); map.put("courseName", "%java%");
	 * map.put("startDate", cal.getTime()); List<Course> courses =
	 * courseService.searchCourses(map); Assert.assertNotNull(courses);
	 * for(Course course : courses){ System.out.println(course); } }
	 * 
	 * @Test public void testSearchCaseCourses(){ Map<String, Object> map = new
	 * HashMap<>(); map.put("searchBy", "Tutor"); map.put("tutorId", 1);
	 * 
	 * List<Course> courses = courseService.searchCaseCourses(map);
	 * System.out.println("testSearchCaseCourses()" + map);
	 * 
	 * Assert.assertNotNull(courses); for(Course couse : courses){
	 * System.out.println(couse); }
	 * 
	 * map.replace("searchBy", "CourseName"); map.remove("tutorId");
	 * map.put("courseName", "%java%");
	 * 
	 * map.clear(); map.put("searchBy", "CourseName"); map.put("courseName",
	 * "%java%"); courses = courseService.searchCaseCourses(map);
	 * System.out.println("testSearchCaseCourses()" + map);
	 * 
	 * Assert.assertNotNull(courses); for(Course course : courses){
	 * System.out.println(course); } }
	 */

	@Test
	public void testSearchWhereCourses() {
		Map<String, Object> map = new HashMap<>();

		List<Course> courses = courseService.searchWhereCourses(map);
		System.out.println("testSearchWhereCourses()" + map);

		Assert.assertNotNull(courses);
		for (Course course : courses) {
			System.out.println(course);
		}

		map.put("tutorId", 1);
		courses = courseService.searchWhereCourses(map);
		System.out.println("testSearchWhereCourses()" + map);

		Assert.assertNotNull(courses);
		for (Course course : courses) {
			System.out.println(course);
		}
		
		map.put("courseName", "%java%");
		courses = courseService.searchWhereCourses(map);
		System.out.println("testSearchWhereCourses()" + map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			System.out.println(course);
		}
		
		map.clear();
		map.put("endDate", new Date());
		courses = courseService.searchWhereCourses(map);
		System.out.println("testSearchWhereCourses()" + map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			System.out.println(course);
		}
	}

}
