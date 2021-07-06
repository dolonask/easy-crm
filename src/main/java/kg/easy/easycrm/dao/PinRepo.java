package kg.easy.easycrm.dao;

import kg.easy.easycrm.models.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinRepo extends JpaRepository<Pin, String> {
}
