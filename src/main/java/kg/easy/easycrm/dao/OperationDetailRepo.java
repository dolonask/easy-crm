package kg.easy.easycrm.dao;

import kg.easy.easycrm.models.OperationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDetailRepo extends JpaRepository<OperationDetail, Long> {
}
