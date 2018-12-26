package com.fih.mobilebrowser.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.models.DeviceInfo;
import com.fih.mobilebrowser.models.SearchConfig;
import com.fih.mobilebrowser.repository.jdbc.SearchConfigJdbcRepository;

@RestController
@RequestMapping(value = "/SearchConfig")
public class SearchConfigController {

	@Autowired
	SearchConfigJdbcRepository SrchConfigRepo;

	@RequestMapping(value = "GetSearchConfig", method = RequestMethod.GET)
	public AppServiceGeneralResponse<List<SearchConfig>> GetSearchConfig(HttpServletRequest request) {
		AppServiceGeneralResponse<List<SearchConfig>> res = new AppServiceGeneralResponse<List<SearchConfig>>();
		try {
			DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
			res.setStatus("Success");
			res.setData(SrchConfigRepo.getSearchConfig(devInfo.getPrjProject()));
		} catch (Exception e) {
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}
}