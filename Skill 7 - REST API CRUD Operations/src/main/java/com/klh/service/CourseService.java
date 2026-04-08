package com.klh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klh.model.Course;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course getCourseById(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course updateCourse(int id, Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId() == id) {
                courseList.set(i, updatedCourse);
                return updatedCourse;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }
        return result;
    }
}
