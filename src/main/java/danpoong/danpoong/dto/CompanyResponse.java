package danpoong.danpoong.dto;

import java.util.List;

public record CompanyResponse(
        String companyName,      // 기업 이름
        String companyLocation,  // 지역명
        List<String> companyCategories,  // 업종 리스트
        String companyType,      // 기업 형태
        String companyInfoPage   // 기업 정보 페이지
) {
}

