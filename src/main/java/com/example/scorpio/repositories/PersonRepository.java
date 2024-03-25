package com.example.scorpio.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scorpio.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}