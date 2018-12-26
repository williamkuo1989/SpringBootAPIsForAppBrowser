package com.fih.mobilebrowser.repository.curd;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fih.mobilebrowser.entities.Nav;

@Repository("NavCurdRepository")
public interface NavCurdRepository extends CrudRepository<Nav,Long> {

	@Query("select Id from Nav")
	List<Long> getAllIds();
}
