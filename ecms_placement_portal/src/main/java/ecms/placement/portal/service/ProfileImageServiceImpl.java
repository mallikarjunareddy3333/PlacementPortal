package ecms.placement.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecms.placement.portal.model.ProfileImage;
import ecms.placement.portal.repository.ProfileImageRepository;

@Service
public class ProfileImageServiceImpl implements ProfileImageService {

	@Autowired
	private ProfileImageRepository profileImgRepo;

	@Override
	public void save(ProfileImage profileImage) {
		profileImgRepo.save(profileImage);
	}

	@Override
	public Optional<ProfileImage> findProfileImageById(Long id) {
		return profileImgRepo.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		profileImgRepo.deleteById(id);
	}

	@Override
	public void update(ProfileImage profileImage) {
		profileImgRepo.save(profileImage);
	}

}
