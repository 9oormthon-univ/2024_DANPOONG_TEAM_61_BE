package danpoong.danpoong.Service;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Repository.AptRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AptService {
    private final AptRepository aptRepository;

    public List<Apt> getAllApt(){
        return aptRepository.findAll();
    }
    public Apt findById(Integer aptID) {
        Optional<Apt> apt = aptRepository.findById(aptID);
        return apt.orElse(null);
        // 있으면 꺼내서 return 없으면 null
    }
}
