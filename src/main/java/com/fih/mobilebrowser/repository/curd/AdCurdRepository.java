package com.fih.mobilebrowser.repository.curd;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fih.mobilebrowser.entities.Ad;

@Repository("AdCurdRepository")
public interface AdCurdRepository extends CrudRepository<Ad,Long> {

	@Query("select Id from Ad")
	List<Long> getAllIds();
}
