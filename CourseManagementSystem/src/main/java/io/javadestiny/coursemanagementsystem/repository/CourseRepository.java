package io.javadestiny.coursemanagementsystem.repository;

import io.javadestiny.coursemanagementsystem.controller.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByTopicId(Long topicId);
}
