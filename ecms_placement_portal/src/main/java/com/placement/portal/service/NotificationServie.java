package com.placement.portal.service;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.placement.portal.model.Notification;

public interface NotificationServie {

	void save(Notification obj);

	void update(Notification obj);
	
	void deleteById(Long id);
	
	Optional<Notification> findById(Long id);

	Page<Notification> findAllNotifications(Pageable pageable);

}
