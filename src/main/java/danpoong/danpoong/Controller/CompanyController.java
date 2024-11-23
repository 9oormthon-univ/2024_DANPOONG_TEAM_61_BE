package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Service.CompanyService;
import danpoong.danpoong.dto.CompanyRequest;
import danpoong.danpoong.dto.CompanyResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * 전체 기업 데이터 가져오기
     * GET /api/company
     * @return
     */
    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /**
     * 특정 기업 데이터 가져오기 (아이콘 클릭)
     * GET /api/company/{companyID}
     * @param companyID
     * @return
     */
    @GetMapping("/{companyID}")
    public CompanyResponse getCompany(@PathVariable Integer companyID) {
        return companyService.getCompanyById(companyID);
    }

    /**
     * 동적 검색 기능 (위치, 형태, 업종)
     * POST /api/company/search
     * @param companyRequest
     * @return
     */
    @PostMapping("/search")
    public List<CompanyResponse> searchCompanies(@RequestBody CompanyRequest companyRequest) {
        return companyService.searchCompanies(
                companyRequest.getLocation(),
                companyRequest.getType(),
                companyRequest.getCategory()
        );
    }
}
