package com.JobApplication.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
//Request mapping at class level /jobs is the base url.
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable int id){
       Job job= jobService.findJobById(id);
       if(job!=null){
           return new ResponseEntity<>(job, HttpStatus.OK);
       }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        String status=jobService.deleteById(id);
        if(status!=null)
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
   /* Request mapping at method level:
   @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)

    */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Job job){
        String status=jobService.updateById(id,job);
        if(status!=null)
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
