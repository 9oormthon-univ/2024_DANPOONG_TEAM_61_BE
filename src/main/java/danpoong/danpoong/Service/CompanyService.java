package danpoong.danpoong.Service;

import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Domain.Category;
import danpoong.danpoong.Repository.CompanyRepository;
import danpoong.danpoong.dto.CompanyResponse;
import org.springframework.data.jpa.domain.Specification;
import danpoong.danpoong.Specification.CompanySpecification;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // 모든 기업 데이터를 가져오는 메서드
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.findAllWithDetails().stream()
                .map(this::convertToDto) // 엔터티 -> DTO 변환
                .collect(Collectors.toList());
    }

    // 특정 기업 데이터를 가져오는 메서드
    public CompanyResponse getCompanyById(Integer companyID) {
        Company company = companyRepository.findByIdWithDetails(companyID)
                .orElseThrow(() -> new RuntimeException("Company with ID " + companyID + " not found."));
        return convertToDto(company); // 엔터티 -> DTO 변환
    }

    // 동적 검색 기능
    public List<CompanyResponse> searchCompanies(String location, String type, String category) {
        Specification<Company> spec = Specification.where(null); // 초기값 설정
        if (location != null && !location.isEmpty()) {
            spec = spec.and(CompanySpecification.hasLocation(location));
        }
        if (type != null && !type.isEmpty()) {
            spec = spec.and(CompanySpecification.hasType(type));
        }
        if (category != null && !category.isEmpty()) {
            spec = spec.and(CompanySpecification.hasCategory(category));
        }
        return companyRepository.findAll(spec).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    // 엔터티 -> DTO 변환 메서드
    private CompanyResponse convertToDto(Company company) {
        return new CompanyResponse(
                company.getCompanyID(),
                company.getCompanyName(),
                company.getCompanyInfoPage(),
                company.getDetailLoc(),
                company.getLocation() != null ? company.getLocation().getLocation() : "No location available", // Null 처리
                company.getType() != null ? company.getType().getType() : "No type available", // Null 처리
                company.getCategories() != null
                        ? company.getCategories().stream()
                        .map(Category::getCategory)
                        .collect(Collectors.toList())
                        : List.of() // Null 처리
        );
    }

}
