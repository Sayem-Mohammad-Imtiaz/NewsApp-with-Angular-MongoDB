package com.sayem.controller;

import com.sayem.model.News;
import com.sayem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sayem on 2/12/2017.
 */
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @PostMapping
    public ResponseEntity<Boolean> addNews(@RequestBody News news) {
        try {
            if (newsService.saveNews(news) == false)
                throw new Exception();
        } catch (Exception ex) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<News>> findAllNews() {
        List<News> list = null;
        try {
            list = newsService.getAllNews();
        } catch (Exception ex) {
            return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
