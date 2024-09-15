package com.JobApplication.Company;

import org.springframework.cache.interceptor.CacheableOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.CompositeName;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        if(companyService.addCompany(company))
            return new ResponseEntity<>("Company Added", HttpStatus.CREATED);
        return new ResponseEntity<>("Company addition failed",HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id,@RequestBody Company company ){
        if(companyService.updateCompany(id,company))
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id){
        if(companyService.deleteCompany(id))
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable int id){
        Company company=companyService.findCompanyId(id);
        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
