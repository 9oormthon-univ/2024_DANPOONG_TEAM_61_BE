package danpoong.danpoong.Controller;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Service.AptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AptController {
    private final AptService aptService;

    @GetMapping("/api/apt")
    public List<Apt> findAllApt(){
        return aptService.getAllApt();
    }
    @GetMapping("/api/apt/{aptID}")
    public ResponseEntity<Apt> findById(@PathVariable Integer aptID){
        Apt apt =aptService.findById(aptID);
        if (apt != null) return ResponseEntity.ok(apt);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
