package danpoong.danpoong.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter // 모든 필드에 대한 Getter 자동 생성
@NoArgsConstructor // JPA 기본 생성자 제공
@EqualsAndHashCode(of = "companyID") // companyID(PK) 기준 equals, hashCode 생성
@ToString // toString 메서드 자동 생성
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key 자동 증가 설정
    private Integer companyID;

    private String companyName;      // 기업 이름
    private String companyLocation;  // 지역명
    private String companyCategory;  // 업종
    private String companyInfoPage;  // 기업 정보 페이지
    private String keyword;          // 검색 키워드

    // 객체 생성 시 초기값을 설정하기 위한 생성자
    public Company(String companyName, String companyLocation, String companyCategory,
                   String companyInfoPage, String keyword) {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.companyCategory = companyCategory;
        this.companyInfoPage = companyInfoPage;
        this.keyword = keyword;
    }
}
