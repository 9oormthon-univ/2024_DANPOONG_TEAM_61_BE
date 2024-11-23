package danpoong.danpoong.Specification;

import org.springframework.data.jpa.domain.Specification;
import danpoong.danpoong.Domain.Company;

public class CompanySpecification {

    // Location 조건
    public static Specification<Company> hasLocation(String location) {
        return (root, query, builder) -> {
            if (location == null || location.isEmpty()) return null;
            return builder.equal(root.join("location").get("location"), location);
        };
    }

    // Type 조건
    public static Specification<Company> hasType(String type) {
        return (root, query, builder) -> {
            if (type == null || type.isEmpty()) return null;
            return builder.equal(root.join("type").get("type"), type);
        };
    }

    // Category 조건
    public static Specification<Company> hasCategory(String category) {
        return (root, query, builder) -> {
            if (category == null || category.isEmpty()) return null;
            return builder.equal(root.join("categories").get("category"), category);
        };
    }

}

