package com.fih.mobilebrowser.repository.curd;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fih.mobilebrowser.entities.Bookmark;

@Repository("BookmarkCurdRepository")
public interface BookmarkCurdRepository extends CrudRepository<Bookmark,Long> {
	List<Bookmark> findByAccIdOrderByCreatedDateAscIdAsc(String AccId);
	List<Bookmark> findByIdAndAccId(Long Id, String AccId);
}
