package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * GET /api/company
     * @return
     */
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /**
     * GET /api/company/{companyID}
     * @param companyID
     * @return
     */
    @GetMapping("/{companyID}")
    public Company getCompany(@PathVariable Integer companyID) {
        return companyService.getCompanyById(companyID);
    }

}
