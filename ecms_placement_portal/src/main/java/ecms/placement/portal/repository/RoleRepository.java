package ecms.placement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecms.placement.portal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String role_name);
}
