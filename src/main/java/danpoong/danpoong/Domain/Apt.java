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
@EqualsAndHashCode(of = "aptID") // aptID(PK) 기준 equals, hashCode 생성
@ToString // toString 메서드 자동 생성 (순환 참조 방지)
public class Apt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key 자동 증가 설정
    private Integer aptID;

    private String umdNm;       // 법정동
    private String aptNm;       // 단지명
    private String jibun;       // 지번
    private String excluUseAr;  // 전용 면적
    private Integer deposit;     // 보증금액
    private Integer monthlyRent; // 월세금액
    private String contractType; // 계약구분

    // 생성자 추가, 객체 생성 시 필드 초기화
    public Apt(String umdNm, String aptNm, String jibun, String excluUseAr,
               Integer deposit, Integer monthlyRent, String contractType) {
        this.umdNm = umdNm;
        this.aptNm = aptNm;
        this.jibun = jibun;
        this.excluUseAr = excluUseAr;
        this.deposit = deposit;
        this.monthlyRent = monthlyRent;
        this.contractType = contractType;
    }
}
