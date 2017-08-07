package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
