package io.javadestiny.coursemanagementsystem.controller;

import io.javadestiny.coursemanagementsystem.controller.Topic;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="course_name")
    private String name;
    @Column(name="description")
    private String description;
    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(Long id, String name, String description, Long topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId,"","");
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
