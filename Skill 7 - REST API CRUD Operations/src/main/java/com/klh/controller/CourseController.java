package com.klh.controller;
import com.klh.model.Course;
import com.klh.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/courses")
public class CourseController {
 private final CourseService courseService;
 public CourseController(CourseService courseService) {
 this.courseService = courseService;
 }
 // CREATING THE COURSE
 @PostMapping
 public ResponseEntity<?> addCourse(@RequestBody Course course) {
 if (course.getCourseId() <= 0) {
 return new ResponseEntity<>("Invalid Course ID", HttpStatus.BAD_REQUEST);
 }
 return new ResponseEntity<>(courseService.addCourse(course),
HttpStatus.CREATED);
 }
 // READING ALL THE COURSES
 @GetMapping
 public ResponseEntity<List<Course>> getAllCourses() {
 return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
 }
 // READING THE COURSE BY ID
 @GetMapping("/{id}")
 public ResponseEntity<?> getCourseById(@PathVariable int id) {
 Course course = courseService.getCourseById(id);
 if (course == null) {
 return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
 }
 return new ResponseEntity<>(course, HttpStatus.OK);
 }
 // UPDATING THE COURSE BY ID
 @PutMapping("/{id}")
 public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course
course) {
 Course updated = courseService.updateCourse(id, course);
 if (updated == null) {
 return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
 }
 return new ResponseEntity<>(updated, HttpStatus.OK);
 }
 // DELETING THE COURSE
 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteCourse(@PathVariable int id) {
 boolean deleted = courseService.deleteCourse(id);
 if (!deleted) {
 return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
 }
 return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
 }
 // SEARCH BY TITLE OF THE COURSE
 @GetMapping("/search/{title}")
 public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {
 return new ResponseEntity<>(courseService.searchByTitle(title), HttpStatus.OK);
 }
} 
