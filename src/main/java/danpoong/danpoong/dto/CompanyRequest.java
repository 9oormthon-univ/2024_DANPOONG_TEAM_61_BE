package danpoong.danpoong.dto;

import java.util.Optional;

public record CompanyRequest (
        // 셋 다 있을 수도 있고 아무것도 없을 수도 있고...
        // 해서 Optional로 넣었습니다
        // 실제 사용할 때는 dto.companyType.isPresent() 같은 걸로 확인해서 있으면 검색하고 없음 말고 하면 댑니다

        Optional<String> companyType,  // 기업형태
        Optional<String> companyCategory,  // 업종
        Optional<String> companyLocation  // 지역명
){
}
