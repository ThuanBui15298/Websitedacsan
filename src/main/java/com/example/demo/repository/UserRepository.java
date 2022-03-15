package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Users;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByEmail(String email);

	@Query(value = "select\r\n"
			+ "	distinct u.*\r\n"
			+ "from\r\n"
			+ "	user u\r\n"
			+ "where\r\n"
			+ "	u.id in\r\n"
			+ "(\r\n"
			+ "	select\r\n"
			+ "		ur.user_id\r\n"
			+ "	from\r\n"
			+ "		roler r\r\n"
			+ "	inner join user_roler ur on\r\n"
			+ "		ur.roler_id = r.id\r\n"
			+ "	where\r\n"
			+ "		r.name_roler = :rolerName)", nativeQuery = true)
	List<Users> findByRoler(@Param(value = "rolerName") String rolerName);

	//List<Users> findByRoler(Set<Roler> roler);



}
