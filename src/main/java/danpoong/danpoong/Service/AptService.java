package danpoong.danpoong.Service;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Repository.AptRepository;
import danpoong.danpoong.dto.AptResponse;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AptService {
    private final AptRepository aptRepository;

    public List<Apt> findAll(){
        return aptRepository.findAll();
    }
    public Apt findById(Integer aptID) {
        Optional<Apt> apt = aptRepository.findById(aptID);
        return apt.orElse(null);
        // 있으면 꺼내서 return 없으면 null
    }
    public List<Apt> findByUmdNm(String umdNm){
        return aptRepository.findByUmdNm(umdNm);
    }
    @Builder
    public AptResponse makeResponse(Apt apt){
        return new AptResponse(apt.getAptNm(), apt.getJibun(), apt.getExcluUseAr(), apt.getDeposit(), apt.getMonthlyRent(), apt.getContractType());
    }
}
