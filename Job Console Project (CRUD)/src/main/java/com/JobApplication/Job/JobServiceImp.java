package com.JobApplication.Job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImp implements JobService{
    private List<Job> jobs=new ArrayList<>();
    private int id=1;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void addJob(Job job) {
        job.setId(id++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(int id) {
        for(Job job:jobs){
            if(job.getId()==id){
                return job;
            }
        }return null;
    }

    @Override
    public String deleteById(int id) {
        for(Job job:jobs){
            if(job.getId()==id){
                jobs.remove(job);
                return "Deleted";
            }
        }return null;
    }

    @Override
    public String updateById(int id, Job updatedJob) {
        for(Job job:jobs){
            if(job.getId()==id){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                return "Updated";
            }
        }return null;
    }
}
