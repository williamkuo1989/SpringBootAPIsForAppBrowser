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

import com.fih.mobilebrowser.entities.Nav;
import com.fih.mobilebrowser.repository.curd.NavCurdRepository;
import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.models.postbody.GetNavPostBody;

@RestController
@RequestMapping(value = "/Nav")
public class NavController {
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	NavCurdRepository navCurdRepo;

	@RequestMapping(value = "GetNav", method = RequestMethod.POST)
	public AppServiceGeneralResponse<Nav> GetNav(HttpServletRequest request, @RequestBody GetNavPostBody body) {
		AppServiceGeneralResponse<Nav> res = new AppServiceGeneralResponse<Nav>();
		try {
			Long NavId = body.getNavId();
			Nav nav = navCurdRepo.findById(NavId).get();
			res.setStatus("Success");
			res.setData(nav);
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value = "GetNavIds", method = RequestMethod.GET)
	public AppServiceGeneralResponse<List<Long>> GetNavIds(HttpServletRequest request) {
		AppServiceGeneralResponse<List<Long>> res = new AppServiceGeneralResponse<List<Long>>();
		try {
			List<Long> ids = navCurdRepo.getAllIds();
			res.setStatus("Success");
			res.setData(ids);
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value = "GetNavs", method = RequestMethod.GET)
	public AppServiceGeneralResponse<Iterable<Nav>> GetNavs(HttpServletRequest request) {
		AppServiceGeneralResponse<Iterable<Nav>> res = new AppServiceGeneralResponse<Iterable<Nav>>();
		try {
			Iterable<Nav> navs = navCurdRepo.findAll();
			res.setStatus("Success");
			res.setData(navs);
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}
}