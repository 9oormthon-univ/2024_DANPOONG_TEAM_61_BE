package danpoong.danpoong.dto;

public record  CompanyResponse (
        String companyName,   // 기업 이름
        String companyLocation,  // 지역명
        String companyCategory,  // 업종
        String companyInfoPage // 기업 정보 페이지
){

}
