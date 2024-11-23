package danpoong.danpoong.Service;

import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAllWithDetails();
    }

}
