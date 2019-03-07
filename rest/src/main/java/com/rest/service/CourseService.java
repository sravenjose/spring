package com.rest.service;

import com.rest.entity.CourseList;

import java.util.List;

public interface CourseService {

   List<CourseList> findAll();

   CourseList findById(String name);

   void save(CourseList theCourse);

   void deleteById(String name);

}
