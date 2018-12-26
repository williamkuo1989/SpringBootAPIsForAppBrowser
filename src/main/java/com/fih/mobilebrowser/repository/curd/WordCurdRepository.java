package com.fih.mobilebrowser.repository.curd;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fih.mobilebrowser.entities.Word;

@Repository("WordCurdRepository")
public interface WordCurdRepository extends CrudRepository<Word,Long> {
	List<Word> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date endDate, Date startDate);

}
