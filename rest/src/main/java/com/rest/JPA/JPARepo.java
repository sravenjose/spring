package com.rest.JPA;

import com.rest.entity.CourseList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPARepo extends JpaRepository<CourseList,String> {

}
