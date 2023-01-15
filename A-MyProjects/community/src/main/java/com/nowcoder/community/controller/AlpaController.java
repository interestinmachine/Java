package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alpa")
public class AlpaController {
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    // students?current=1&limit=4
    public String getStudent(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String student(@PathVariable("id")int id) {
        System.out.println(id);
        return "one student";
    }
}
