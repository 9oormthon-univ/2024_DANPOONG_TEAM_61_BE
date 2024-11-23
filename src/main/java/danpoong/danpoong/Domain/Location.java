package danpoong.danpoong.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Location {
    @Id
    private Integer companyID; // Company와 1:1 관계, FK이자 PK

    private String location; // 기업 위치

    @OneToOne
    @MapsId // companyID를 FK이자 PK로 사용
    @JoinColumn(name = "companyID")
    @JsonBackReference
    private Company company;

    public Location(String location) {
        this.location = location;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
