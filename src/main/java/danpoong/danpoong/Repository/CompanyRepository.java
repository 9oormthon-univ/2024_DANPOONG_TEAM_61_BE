package danpoong.danpoong.Repository;

import danpoong.danpoong.Domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {

    // 전체 기업 조회
    @Query("SELECT DISTINCT c FROM Company c " +
            "LEFT JOIN FETCH c.location " +
            "LEFT JOIN FETCH c.type " +
            "LEFT JOIN FETCH c.categories")
    List<Company> findAllWithDetails();

    // 특정 기업 조회 (아이콘 클릭 & 검색)
    @Query("SELECT c FROM Company c " +
            "LEFT JOIN FETCH c.location " +
            "LEFT JOIN FETCH c.type " +
            "LEFT JOIN FETCH c.categories " +
            "WHERE c.companyID = :companyID")
    Optional<Company> findByIdWithDetails(@Param("companyID") Integer companyID);

}