package com.fih.mobilebrowser.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.models.DeviceInfo;
import com.fih.mobilebrowser.models.postbody.UploadDataPostBody;
import com.fih.mobilebrowser.models.uploaddata.Attr;
import com.fih.mobilebrowser.models.uploaddata.Rec;


@RestController
@RequestMapping(value = "/Data")
public class DataCollectController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	final String sql = "insert into DataCollect (Model,Event,AdId,ChannelId,AdSrc,ClickUrl,KeyWord,KeyWordSrc,RecmdUrl,RecmdUrlSrc,AccId,IMEI,PSN,AnVer,Net,NetOp,SDen,Lan,PkgName,AnVerName,AnVerCode,Prj,Date) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	@Autowired
	DataSource dc;	

	@RequestMapping(value = "UploadData", method = RequestMethod.POST)
	public AppServiceGeneralResponse<?> UploadData(@RequestBody UploadDataPostBody body, HttpServletRequest request) {
		DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
		AppServiceGeneralResponse<?> res = new AppServiceGeneralResponse<Void>();
		int[] numGetBatched = new int[0];
		try {
			Connection connection = dc.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);

			Rec[] recs = body.getData();
			if (recs != null && recs.length > 0) {
				for (int i = 0 ; i < recs.length ; i++) {
					Rec rec = recs[i];
					ps.setNString(1, rec.getModel());
					ps.setNString(2, rec.getEvent());
					// handle attr
					if (rec.getAttr() != null) {
						Attr attr = rec.getAttr();
						ps.setNString(3, attr.getAdId());
						ps.setNString(4, attr.getChannelId());
						ps.setNString(5, attr.getAdSrc());
						ps.setNString(6, attr.getClickUrl());
						ps.setNString(7, attr.getKeyWord());
						ps.setNString(8, attr.getKeyWordSrc());
						ps.setNString(9, attr.getRecmdUrl());
						ps.setNString(10, attr.getRecmdUrlSrc());
					} else {
						for (int j = 3 ; j < 11 ; j++) {
							ps.setNString(j, null);
						}
					}
					// handle device info
					if (devInfo != null) {
						ps.setNString(11, devInfo.getAccId());
						ps.setNString(12, devInfo.getIMEI());
						ps.setNString(13, devInfo.getPSN());
						ps.setNString(14, devInfo.getAnVer());
						ps.setNString(15, devInfo.getNet());
						ps.setNString(16, devInfo.getNetOp());
						ps.setNString(17, devInfo.getSDen());
						ps.setNString(18, devInfo.getLan());
						ps.setNString(19, devInfo.getPkgName());
						ps.setNString(20, devInfo.getAnVerName());
						ps.setNString(21, devInfo.getAnVerCode());
						ps.setNString(22, devInfo.getPrj());
					} else {
						for (int j = 11 ; j < 23 ; j++) {
							ps.setNString(j, null);
						}
					}
					ps.setTimestamp(23, new Timestamp(rec.getDate()));
					ps.addBatch();
				}
			}
			numGetBatched = ps.executeBatch();
			ps.close();
			connection.close();
			res.setStatus("Success");
		} catch (Exception e) {
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage(e.getMessage());
		} finally {
			logger.info("{} recs flushed into db.", numGetBatched.length);
		}

		return res;
	}

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public DeviceInfo Test(HttpServletRequest request) {
		DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
		return devInfo;
	}
}