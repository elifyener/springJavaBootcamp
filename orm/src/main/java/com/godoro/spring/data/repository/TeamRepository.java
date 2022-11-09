package com.godoro.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.data.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
