package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Course;
import com.demo.repository.CourseRepository;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	@Override
	public Course getCourse(String id) {

		return courseRepository.findOne(id);

	}

	@Override
	public String addCourse(Course course) {

		courseRepository.save(course);

		return course.getId();
	}

	@Override
	public Course updateCourse(String id, Course course) {

		courseRepository.delete(id);

		return courseRepository.save(course);

	}

	@Override
	public Course deleteCourse(String id) {

		Course course = courseRepository.findOne(id);
		courseRepository.delete(id);
		return course;
	}

}
