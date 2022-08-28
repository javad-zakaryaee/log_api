package com.samin.log_api.controller;

import com.samin.log_api.model.Log;
import com.samin.log_api.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class LogController {
    @Autowired
    LogRepository logRepository;
    @GetMapping("/logs")
    public ResponseEntity<Page<Log>> getAllLogs(@RequestParam Optional<Integer> page,
                                                     @RequestParam Optional<String> sortBy) {
        try {
            Page<Log> logs =  logRepository.findAll(
                    PageRequest.of(page.orElse(0),
                            10, Sort.Direction.ASC,
                            sortBy.orElse("id")));
            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/logs/{id}")
    public ResponseEntity<Log> getLogsById(@PathVariable("id") String id) {
        Optional<Log> logData = logRepository.findById(id);
        if (logData.isPresent()) {
            return new ResponseEntity<>(logData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/logs/user/{userId}")
    public ResponseEntity<Page<Log>> getLogsByUser(@PathVariable("userId") String id,@RequestParam Optional<Integer> page,
                                                       @RequestParam Optional<String> sortBy) {
        try {
            Page<Log> logs =  logRepository.findAllByUserId(id,
                    PageRequest.of(page.orElse(0),
                            10, Sort.Direction.ASC,
                            sortBy.orElse("id")));
            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/logs/type/{type}")
    public ResponseEntity<Page<Log>> getLogsByType(@PathVariable("type") String id,@RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<String> sortBy) {
        try {
            Page<Log> logs =  logRepository.findAllByType(id,
                    PageRequest.of(page.orElse(0),
                            10, Sort.Direction.ASC,
                            sortBy.orElse("id")));
            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/logs/client/{clientId}")
    public ResponseEntity<Page<Log>> getLogsByClient(@PathVariable("clientId") String id,@RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<String> sortBy) {
        try {
            Page<Log> logs =  logRepository.findAllByClientId(id,
                    PageRequest.of(page.orElse(0),
                            10, Sort.Direction.ASC,
                            sortBy.orElse("id")));
            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/logs/ipaddress/{ipAddress}")
    public ResponseEntity<Page<Log>> getLogsByIp(@PathVariable("ipAddress") String id,@RequestParam Optional<Integer> page,
                                                     @RequestParam Optional<String> sortBy) {
        try {
            Page<Log> logs =  logRepository.findAllByIpAddress(id,
                    PageRequest.of(page.orElse(0),
                            10, Sort.Direction.ASC,
                            sortBy.orElse("id")));
            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(logs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
