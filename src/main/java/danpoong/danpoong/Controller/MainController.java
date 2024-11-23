package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Domain.Company;
import danpoong.danpoong.Service.AptService;
import danpoong.danpoong.dto.AptResponse;
import danpoong.danpoong.dto.CombinedResponse;
import danpoong.danpoong.dto.CompanyResponse;
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
    public CombinedResponse findDefault(){
        List<AptResponse> al = aptService.findByUmdNm("백현동").stream()
                .map(aptService::makeResponse) // Apt -> AptResponse 변환
                .toList();
        List<CompanyResponse> cl = companyController.getAllCompanies();
        // List<Company> cl = companyController.findByLocation("판교");

        // 한 번에 return하지만 둘 다 가지고 있어야 함
        return new CombinedResponse(al, cl);
    }
}
