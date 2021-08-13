package io.javadestiny.coursemanagementsystem.service;

import io.javadestiny.coursemanagementsystem.controller.Topic;
import io.javadestiny.coursemanagementsystem.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public  List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(Long id){
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Long id, Topic topic) {
        Topic existingTopic = topicRepository.getById(id);
        existingTopic.setId(id);
        existingTopic.setName(topic.getName());
        existingTopic.setDescription(topic.getDescription());
        topicRepository.save(existingTopic);
    }

    public void deleteTopic(Long id) {
        Topic existingTopic = topicRepository.getById(id);
        topicRepository.delete(existingTopic);
    }
}
