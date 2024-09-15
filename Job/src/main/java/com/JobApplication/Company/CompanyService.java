package com.JobApplication.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    boolean addCompany(Company company);
    boolean updateCompany(int id,Company company);

    boolean deleteCompany(int id);

    Company findCompanyId(int id);
}
