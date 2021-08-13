package io.javadestiny.coursemanagementsystem.service;

import io.javadestiny.coursemanagementsystem.controller.Course;
import io.javadestiny.coursemanagementsystem.repository.CourseRepository;
import io.javadestiny.coursemanagementsystem.controller.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public  List<Course> getAllCourses(Long topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;

    }

    public Course getCourse(Long id){
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course, Long topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteTopic(Long id) {
        courseRepository.deleteById(id);
    }
}
