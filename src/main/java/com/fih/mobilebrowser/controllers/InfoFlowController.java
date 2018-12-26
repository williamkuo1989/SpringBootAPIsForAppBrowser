package com.fih.mobilebrowser.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.models.DeviceInfo;
import com.fih.mobilebrowser.models.InfoFlow;
import com.fih.mobilebrowser.repository.jdbc.InfoFlowJdbcRepository;

@RestController
@RequestMapping(value = "/InfoFlow")
public class InfoFlowController {

	@Autowired
	InfoFlowJdbcRepository InfoFlowRepo;

	@RequestMapping(value = "GetInfoFlows", method = RequestMethod.GET)
	public AppServiceGeneralResponse<List<InfoFlow>> GetInfoFlows(HttpServletRequest request) {
		AppServiceGeneralResponse<List<InfoFlow>> res = new AppServiceGeneralResponse<List<InfoFlow>>();
		try {
			DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
			res.setStatus("Success");
			res.setData(InfoFlowRepo.getInfoFlow(devInfo.getPrjProject()));
		} catch (Exception e){
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		}
		return res;
	}
}