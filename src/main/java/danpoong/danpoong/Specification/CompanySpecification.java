package danpoong.danpoong.Specification;

import org.springframework.data.jpa.domain.Specification;
import danpoong.danpoong.Domain.Company;

public class CompanySpecification {

    // Location 조건
    public static Specification<Company> hasLocation(String location) {
        return (root, query, builder) -> location == null || location.isEmpty()
                ? null
                : builder.equal(root.get("location").get("location"), location);
    }

    // Type 조건
    public static Specification<Company> hasType(String type) {
        return (root, query, builder) -> type == null || type.isEmpty()
                ? null
                : builder.equal(root.get("type").get("type"), type);
    }

    // Category 조건
    public static Specification<Company> hasCategory(String category) {
        return (root, query, builder) -> category == null || category.isEmpty()
                ? null
                : builder.equal(root.join("categories").get("category"), category);
    }
}

