package com.rest.rest;


import com.rest.entity.CourseList;
import com.rest.service.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRest {

    private CourseService courseService;


    public CourseRest(CourseService cs) {
        this.courseService = cs;

    }

    @GetMapping("/courses")
    public List<CourseList> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{name}")
    public CourseList get(@PathVariable String name) {

        CourseList c = courseService.findById(name);
        return c;
    }

    @PostMapping("/courses")
    public
    @ResponseBody CourseList add( CourseList c) {
        courseService.save(c);
        return c;
    }

    @PutMapping("/courses")
    public
    @ResponseBody CourseList update( CourseList c) {
        courseService.save(c);
        return c;
    }

    @DeleteMapping("/courses/{cname}")
    public String remove(@PathVariable String cname) {
        CourseList temp = courseService.findById(cname);

        if (temp == null) {
            throw new RuntimeException(" not found - " + cname);
        }
        courseService.deleteById(cname);
        return "Deleted";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }



}
