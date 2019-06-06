package ecms.placement.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ecms.placement.portal.model.Notification;
import ecms.placement.portal.repository.NotificationsRepository;

@Service
public class NotificationsServiceImpl implements NotificationServie {

	@Autowired
	private NotificationsRepository notifyRepo;

	@Override
	public void save(Notification obj) {
		notifyRepo.save(obj);
	}

	@Override
	public void update(Notification obj) {
		notifyRepo.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		notifyRepo.deleteById(id);
	}

	@Override
	public Optional<Notification> findById(Long id) {
		return notifyRepo.findById(id);
	}

	@Override
	public Page<Notification> findAllNotifications(Pageable pageable) {
		return notifyRepo.findAll(pageable);
	}

}
