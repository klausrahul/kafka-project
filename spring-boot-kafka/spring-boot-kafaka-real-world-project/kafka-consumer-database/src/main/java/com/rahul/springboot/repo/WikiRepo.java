package com.rahul.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.springboot.entity.WikimediaData;

public interface WikiRepo extends JpaRepository<WikimediaData, Long> {

}
