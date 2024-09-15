package com.JobApplication.Company;

import com.JobApplication.Job.Job;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public boolean addCompany(Company company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCompany(int id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setDescription(updatedCompany.getDescription());
            company.setName(updatedCompany.getName());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(int id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }return false;
    }

    @Override
    public Company findCompanyId(int id) {
        if(companyRepository.existsById(id)){
            return companyRepository.findById(id).orElse(null);
        }
        return null;
    }
}
