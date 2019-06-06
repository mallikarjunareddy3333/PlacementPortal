package ecms.placement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecms.placement.portal.model.ProfileImage;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
	
}
