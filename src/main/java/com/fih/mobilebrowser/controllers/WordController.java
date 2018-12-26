package com.fih.mobilebrowser.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fih.mobilebrowser.repository.curd.WordCurdRepository;
import com.fih.mobilebrowser.entities.Word;
import com.fih.mobilebrowser.models.AppServiceGeneralResponse;

@RestController
@RequestMapping(value = "/Word")
public class WordController {
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	WordCurdRepository wordCurdRepo;

	@RequestMapping(value = "GetWords", method = RequestMethod.GET)
	public AppServiceGeneralResponse<List<String>> GetAdIds(HttpServletRequest request) {
		AppServiceGeneralResponse<List<String>> res = new AppServiceGeneralResponse<List<String>>();
		try {
			Date today = new Date();
			List<Word> ids = wordCurdRepo.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(today, today);
			List<String> strings = ids.stream().map(Word::getWord)
                    .collect(Collectors.toList());
			res.setStatus("Success");
			res.setData(strings);
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}
}