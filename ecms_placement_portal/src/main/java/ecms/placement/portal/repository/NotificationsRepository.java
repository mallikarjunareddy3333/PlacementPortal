package ecms.placement.portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecms.placement.portal.model.Notification;

@Repository
public interface NotificationsRepository extends JpaRepository<Notification, Long> {

	Page<Notification> findAll(Pageable pageable);

}
