package kg.easy.easycrm.dao;

import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;
import kg.easy.easycrm.models.Operation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<Operation, Long> {



    @Query("select u from Operation u where u.pin.pin = ?1 order by u.id desc")
    List<Operation> findAllByPin(String pin, Pageable pageable);
}
