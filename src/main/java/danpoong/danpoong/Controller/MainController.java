package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Service.AptService;
import danpoong.danpoong.dto.CombinedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class MainController {
    private final AptService aptService;
    private final CompanyController companyController;

    @GetMapping
    public CombinedResponse findByLocation(){
        List<Apt> al = aptService.findByUmdNm("백현동");
        List<Company> cl = companyController.getAllCompanies();
        // List<Company> cl = companyController.findByLocation("판교");
        // TBD...

        // 한 번에 return하지만 둘 다 가지고 있어야 함
        return new CombinedResponse(al, cl);
    }
}
