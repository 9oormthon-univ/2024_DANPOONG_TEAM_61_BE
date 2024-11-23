package danpoong.danpoong.dto;

import java.util.List;

public record CompanyResponse(
        Integer companyID,        // 기업 ID
        String companyName,       // 기업 이름
        String companyInfoPage,   // 기업 정보 페이지
        String detailLoc,         // 상세 주소 추가
        String location,          // 위치
        String type,              // 기업 형태
        List<String> categories   // 업종 리스트
) {
}
