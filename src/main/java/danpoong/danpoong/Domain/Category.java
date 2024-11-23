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
@EqualsAndHashCode(of = "categoryID")
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID; // 카테고리 ID (PK)

    private String category; // 업종

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyID")
    @JsonBackReference
    private Company company;

    public Category(String category) {
        this.category = category;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
