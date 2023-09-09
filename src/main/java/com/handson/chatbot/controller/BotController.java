package com.handson.chatbot.controller;

import com.handson.chatbot.service.AmazonService;
import com.handson.chatbot.service.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    AmazonService amazonService;
    @Autowired
    JokesService jokesService;

    @RequestMapping(value = "/amazon", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@RequestParam String keyword) throws IOException {
        return new ResponseEntity<>(amazonService.searchProducts(keyword), HttpStatus.OK);
    }

    @RequestMapping(value = "/jokes", method = RequestMethod.GET)
    public ResponseEntity<?> getJokes(@RequestParam String keyword) throws IOException {
        return new ResponseEntity<>(jokesService.getJokeId(keyword), HttpStatus.OK);
    }
}

