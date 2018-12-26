package com.fih.mobilebrowser.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fih.mobilebrowser.entities.Ad;
import com.fih.mobilebrowser.repository.curd.AdCurdRepository;
import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.models.postbody.GetAdPostBody;

@RestController
@RequestMapping(value = "/Ad")
public class AdController {
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	AdCurdRepository adCurdRepo;

	@RequestMapping(value = "GetAd", method = RequestMethod.POST)
	public AppServiceGeneralResponse<Ad> GetAd(HttpServletRequest request, @RequestBody GetAdPostBody body) {
		AppServiceGeneralResponse<Ad> res = new AppServiceGeneralResponse<Ad>();
		try {
			Long AdId = body.getAdId();
			Ad ad = adCurdRepo.findById(AdId).get();
			res.setStatus("Success");
			res.setData(ad);
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value = "GetAdIds", method = RequestMethod.GET)
	public AppServiceGeneralResponse<List<Long>> GetAdIds(HttpServletRequest request) {
		AppServiceGeneralResponse<List<Long>> res = new AppServiceGeneralResponse<List<Long>>();
		try {
			List<Long> ids = adCurdRepo.getAllIds();
			res.setStatus("Success");
			res.setData(ids);
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}
}