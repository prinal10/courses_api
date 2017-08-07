package com.demo.service;

import java.util.List;

import com.demo.model.Course;

public interface CourseService {

	List<Course> getAllCourses(String id);

	Course getCourse(String id);

	String addCourse(Course course);

	Course updateCourse(String id, Course course);

	Course deleteCourse(String id);

}
