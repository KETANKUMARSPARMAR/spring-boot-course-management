package io.javadestiny.coursemanagementsystem.controller;

import io.javadestiny.coursemanagementsystem.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){

        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @RequestMapping( method = RequestMethod.POST, value = "/topics")
    public void addTopics(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopics(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopics(@PathVariable Long id){
      topicService.deleteTopic(id);
    }

    //Spring security APIs
    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome HOME page</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome USER page</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome ADMIN page</h1>");
    }
}
