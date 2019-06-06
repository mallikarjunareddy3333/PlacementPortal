package ecms.placement.portal.rest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecms.placement.portal.dto.ApiResponse;
import ecms.placement.portal.dto.NotificationDto;
import ecms.placement.portal.model.Notification;
import ecms.placement.portal.service.NotificationServie;

@RestController
@RequestMapping("/notifications")
public class NotificationsRest {

	@Autowired
	private NotificationServie notifServie;

	@PostMapping
	public ApiResponse<String> createNotification(@Valid @RequestBody NotificationDto objDto) {
		Notification obj = new Notification(objDto.getTitle(), objDto.getBody(), LocalTime.now());
		notifServie.save(obj);
		return new ApiResponse<>(HttpStatus.CREATED.value(), "Notification created successfully.", "");
	}

	@PutMapping("/{id}")
	public ApiResponse<String> updateNotification(@PathVariable Long id, @Valid @RequestBody NotificationDto objDto)
			throws Exception {

		Optional<Notification> opt = notifServie.findById(id);
		Notification obj = null;

		if (opt.isPresent()) {
			obj = opt.get();

			obj.setTitle(objDto.getTitle());
			obj.setBody(objDto.getBody());
			obj.setUpdatedAt(LocalDateTime.now());

			notifServie.update(obj);

		} else {
			throw new Exception("Invalid notification id to do action");
		}

		return new ApiResponse<>(HttpStatus.OK.value(), "Notification updated successfully.", "");
	}

	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteNotification(@PathVariable Long id) {
		notifServie.deleteById(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "Notification deleted successfully.", "");
	}

	@GetMapping("/{id}")
	public ApiResponse<String> getNotification(@PathVariable Long id) throws Exception {
		Optional<Notification> opt = notifServie.findById(id);

		if (!opt.isPresent())
			throw new Exception("Invalid notification id to do action");

		return new ApiResponse<>(HttpStatus.OK.value(), "Notification retrive successfully.", opt.get());
	}

	@GetMapping
	public ApiResponse<List<Notification>> getNotifications(@RequestParam int page) {
		PageRequest pageable = PageRequest.of(page - 1, 10, Sort.by("updatedAt").descending());
		Page<Notification> objs = notifServie.findAllNotifications(pageable);
		return new ApiResponse<>(HttpStatus.OK.value(), "Notifications retrive successfully.", objs);
	}

}
