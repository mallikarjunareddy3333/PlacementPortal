package ecms.placement.portal.service;

import java.util.Optional;

import ecms.placement.portal.model.ProfileImage;

public interface ProfileImageService {

	void save(ProfileImage profileImage);

	Optional<ProfileImage> findProfileImageById(Long id);

	void deleteById(Long id);

	void update(ProfileImage profileImage);

}
