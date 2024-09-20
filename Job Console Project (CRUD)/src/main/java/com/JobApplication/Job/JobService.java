package com.JobApplication.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void addJob(Job job);

    Job findJobById(int id);

    String deleteById(int id);

    String updateById(int id, Job job);
}
