package danpoong.danpoong.dto;

import java.util.Optional;

public record AptRequest(
        Optional<String> umdNm,
        // 최소-최대 보증금/월세
        // dto.lowerBoundDeposit.isPresent()
        // 있으면 검색에 쓰고 없으면 말고
        Optional<Integer> lowerBoundDeposit,
        Optional<Integer> upperBoundDeposit,
        Optional<Integer> lowerBoundMonthlyRent,
        Optional<Integer> upperBoundMonthlyRent
) {
}
