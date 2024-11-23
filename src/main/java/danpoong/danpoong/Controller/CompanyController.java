package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Service.CompanyService;
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
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /**
     * 특정 기업 데이터 가져오기 (아이콘 클릭)
     * GET /api/company/{companyID}
     * @param companyID
     * @return
     */
    @GetMapping("/{companyID}")
    public Company getCompany(@PathVariable Integer companyID) {
        return companyService.getCompanyById(companyID);
    }

    /**
     * 검색 기능 (위치, 형태, 업종)
     * GET /api/company/search?keyword={keyword}
     * @param location
     * @param type
     * @param category
     * @return
     */
    @GetMapping("/search")
    public List<Company> searchCompanies(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category) {
        return companyService.searchCompanies(location, type, category);
    }
}
