package danpoong.danpoong.Domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "companyID")
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyID;

    private String companyName;       // 기업 이름

    private String companyInfoPage;   // 기업 정보 페이지

    private String detailLoc; // 상세 주소

    // 1:1 관계 - Location
    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Location location;

    // 1:1 관계 - Type
    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Type type;

    // 1:N 관계 - Categories
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Category> categories = new ArrayList<>();

    // 생성자
    public Company(String companyName, String companyInfoPage, String detailLoc) {
        this.companyName = companyName;
        this.companyInfoPage = companyInfoPage;
        this.detailLoc = detailLoc;
    }

    // 연관 관계 메서드 (편의 메서드)
    public void setLocation(Location location) {
        this.location = location;
        location.setCompany(this); // 양방향 관계 설정
    }

    public void setType(Type type) {
        this.type = type;
        type.setCompany(this); // 양방향 관계 설정
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.setCompany(this); // 양방향 관계 설정
    }
}
