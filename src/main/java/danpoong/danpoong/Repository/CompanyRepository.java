package danpoong.danpoong.Repository;

import danpoong.danpoong.Domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("SELECT DISTINCT c FROM Company c " +
            "LEFT JOIN FETCH c.location " +
            "LEFT JOIN FETCH c.type " +
            "LEFT JOIN FETCH c.categories")
    List<Company> findAllWithDetails();
}