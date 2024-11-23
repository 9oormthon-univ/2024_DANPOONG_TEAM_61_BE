package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Service.AptService;
import danpoong.danpoong.dto.AptRequest;
import danpoong.danpoong.dto.AptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/apt")
@RequiredArgsConstructor
public class AptController {
    private final AptService aptService;

    @GetMapping
    public List<Apt> findAllApt(){
        return aptService.findAll();
    }
    @GetMapping("/{aptID}")
    public ResponseEntity<AptResponse> findById(@PathVariable Integer aptID){
        AptResponse aptResponse =aptService.makeResponse(aptService.findById(aptID));
        if (aptResponse != null) return ResponseEntity.ok(aptResponse);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/search")
    public List<AptResponse> findByFilter(@RequestBody AptRequest aptRequest){
        List<Apt> al = aptService.findAll();
        al = al.stream()
                .filter(apt ->
                    // 법정동
                    (aptRequest.umdNm().isEmpty() || apt.getUmdNm().equals(aptRequest.umdNm().get()) &&
                        // 보증금(lowerBoundDeposit)
                        (aptRequest.lowerBoundDeposit().isEmpty() || apt.getDeposit().compareTo(aptRequest.lowerBoundDeposit().get()) >= 0) &&
                        // 보증금(upperBoundDeposit)
                        (aptRequest.upperBoundDeposit().isEmpty() || apt.getDeposit().compareTo(aptRequest.upperBoundDeposit().get()) <= 0) &&
                        // 월세(lowerBoundMonthlyRent)
                        (aptRequest.lowerBoundMonthlyRent().isEmpty() || apt.getMonthlyRent().compareTo(aptRequest.lowerBoundMonthlyRent().get()) >= 0) &&
                        // 월세(upperBoundMonthlyRent)
                        (aptRequest.upperBoundMonthlyRent().isEmpty() || apt.getMonthlyRent().compareTo(aptRequest.upperBoundMonthlyRent().get()) <= 0)
                    )
                ).toList();
        return al.stream()
                .map(aptService::makeResponse) // Apt -> AptResponse 변환
                .toList(); // Stream 결과를 List로 변환
    }
}
