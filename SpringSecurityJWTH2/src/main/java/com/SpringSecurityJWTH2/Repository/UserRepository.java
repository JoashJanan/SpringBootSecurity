package com.SpringSecurityJWTH2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurityJWTH2.Entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	 Optional<AppUser> findByUsername(String username);

}
