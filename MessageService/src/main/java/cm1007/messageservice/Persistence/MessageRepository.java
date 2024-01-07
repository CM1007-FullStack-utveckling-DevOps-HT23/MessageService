package cm1007.messageservice.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message_T, Long> {
    List<Message_T> findAllBySourceUserId(String userId);
    List<Message_T> findAllByTargetUserIdAndAnswerIsNull(String userId);
}
