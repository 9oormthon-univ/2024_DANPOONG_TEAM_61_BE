package danpoong.danpoong.dto;

import danpoong.danpoong.Domain.Apt;
import danpoong.danpoong.Domain.Company;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

public record CombinedResponse(
        List<AptResponse> apt,         // Apt 객체(Optional로 감쌈)
        List<CompanyResponse> company  // Company 객체(Optional로 감쌈)
) {
}