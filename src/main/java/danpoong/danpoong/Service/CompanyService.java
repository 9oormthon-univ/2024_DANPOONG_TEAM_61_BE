package danpoong.danpoong.Service;

import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Repository.CompanyRepository;
import org.springframework.data.jpa.domain.Specification;
import danpoong.danpoong.Specification.CompanySpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // 모든 기업 데이터를 가져오는 메서드
    public List<Company> getAllCompanies() {
        return companyRepository.findAllWithDetails();
    }

    // 특정 기업 데이터를 가져오는 메서드
    public Company getCompanyById(Integer companyID) {
        return companyRepository.findByIdWithDetails(companyID)
                .orElseThrow(() -> new RuntimeException("Company with ID " + companyID + " not found."));
    }

    // 동적 검색 기능
    public List<Company> searchCompanies(String location, String type, String category) {
        Specification<Company> spec = Specification.where(CompanySpecification.hasLocation(location))
                .and(CompanySpecification.hasType(type))
                .and(CompanySpecification.hasCategory(category));
        return companyRepository.findAll(spec);
    }
}
