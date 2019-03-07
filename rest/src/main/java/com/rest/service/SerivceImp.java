package com.rest.service;

import com.rest.JPA.JPARepo;
import com.rest.entity.CourseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class SerivceImp implements  CourseService {
    private JPARepo jpaRepo;

    @Autowired
    public SerivceImp(JPARepo thejpaRepo) {
        this.jpaRepo = thejpaRepo;
    }

    @Override
    public List<CourseList> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public CourseList findById(String name) {
        Optional<CourseList> result = jpaRepo.findById(name);

        CourseList theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {

            throw new RuntimeException("Did not find  - " + name);
        }

        return theCourse;
    }

    @Override
    public void save(CourseList theCourse) {
        jpaRepo.save(theCourse);

    }

    @Override
    public void deleteById(String name) {
        jpaRepo.deleteById(name);

    }
}
