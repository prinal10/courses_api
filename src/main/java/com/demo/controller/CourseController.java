package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Course;
import com.demo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {

		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopicId(topicId);
		return courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course, @PathVariable("courseId") String id,
			@PathVariable("topicId") String topicId) {
		course.setTopicId(topicId);
		return courseService.updateCourse(id, course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{courseId}")
	public Course deleteCourse(@PathVariable("courseId") String id) {
		return courseService.deleteCourse(id);
	}
}
