package danpoong.danpoong.Repository;

import danpoong.danpoong.Domain.Apt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AptRepository extends JpaRepository<Apt, Integer> {
    List<Apt> findByUmdNm(String umdNm);
}