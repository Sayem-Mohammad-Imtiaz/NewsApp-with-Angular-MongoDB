package com.sayem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by sayem on 2/14/2017.
 */
@Controller
public class ViewController {
    @GetMapping("/")
    public String getDefaultView()
    {
        return "templates/index.html";
    }

    @GetMapping("addStory")
    public String getAddStoryView()
    {
        return "templates/add_story.html";
    }
}
