package danpoong.danpoong.Domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "companyID")
@ToString
public class Type {
    @Id
    private Integer companyID; // Company와 1:1 관계, FK이자 PK

    private String type; // 기업 형태

    @OneToOne
    @MapsId // companyID를 FK이자 PK로 사용
    @JoinColumn(name = "companyID")
    private Company company;

    public Type(String type) {
        this.type = type;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
