package com.fih.mobilebrowser.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fih.mobilebrowser.entities.Bookmark;
import com.fih.mobilebrowser.repository.curd.BookmarkCurdRepository;
import com.fih.mobilebrowser.service.BookmarkService;
import com.fih.mobilebrowser.models.AppServiceGeneralResponse;
import com.fih.mobilebrowser.models.DeviceInfo;
import com.fih.mobilebrowser.models.deletebody.BookmarkDeleteBody;
import com.fih.mobilebrowser.models.postbody.UploadBookmarksPostBody;

@RestController
@RequestMapping(value = "/Bookmark")
public class BookmarkController {
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	BookmarkCurdRepository bookmarkCurdRepo;

	@Autowired
	BookmarkService bookmarkService;

	@RequestMapping(value = "GetBookmarks", method = RequestMethod.GET)
	public AppServiceGeneralResponse<List<Bookmark>> GetBookmarks(HttpServletRequest request) {
		DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
		AppServiceGeneralResponse<List<Bookmark>> res = new AppServiceGeneralResponse<List<Bookmark>>();
		if (devInfo == null || devInfo.getAccId() == null || devInfo.getAccId().equals("")) {
			res.setStatus("Error");
			res.setErrorMessage("Need to login Nokia accont.");
			return res;
		}

		try {
			res.setData(bookmarkService.Get(devInfo.getAccId()));
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage("Get bookmarks failed.");
		}

		return res;
	}

	@RequestMapping(value = "UploadBookmarks", method = RequestMethod.POST)
	public AppServiceGeneralResponse<Iterable<Bookmark>> UploadBookmarks(HttpServletRequest request, @RequestBody UploadBookmarksPostBody body) {
		DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
		AppServiceGeneralResponse<Iterable<Bookmark>> res = new AppServiceGeneralResponse<Iterable<Bookmark>>();
		if (devInfo == null || devInfo.getAccId() == null || devInfo.getAccId().equals("")) {
			res.setStatus("Error");
			res.setErrorMessage("Need to login Nokia accont.");
			return res;
		}

		try {
			res.setData(bookmarkService.Upload(body.getBookmarkArr(), devInfo.getAccId()));
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage("Upload bookmarks failed.");
			return res;
		}

		return res;
	}

	@RequestMapping(value = "UpdateBookmarks", method = RequestMethod.POST)
	public AppServiceGeneralResponse<List<Long>> UpdateBookmarks(HttpServletRequest request, @RequestBody UploadBookmarksPostBody body) {
		DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
		AppServiceGeneralResponse<List<Long>> res = new AppServiceGeneralResponse<List<Long>>();
		if (devInfo == null || devInfo.getAccId() == null || devInfo.getAccId().equals("")) {
			res.setStatus("Error");
			res.setErrorMessage("Need to login Nokia accont.");
			return res;
		}

		try {
			bookmarkService.Update(body.getBookmarkArr(), devInfo.getAccId());
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage("Update bookmarks failed.");
			List<Long> longList = body.getBookmarkArr().stream().map(Bookmark::getid).collect(Collectors.toList());
			res.setData(longList);
			return res;
		}

		return res;
	}

	@RequestMapping(value = "DeleteBookmarks", method = RequestMethod.DELETE)
	public AppServiceGeneralResponse<Long[]> DeleteBookMarks(HttpServletRequest request, @RequestBody BookmarkDeleteBody body) {
		DeviceInfo devInfo = (DeviceInfo) request.getAttribute("deviceinfo");
		AppServiceGeneralResponse<Long[]> res = new AppServiceGeneralResponse<Long[]>();
		if (devInfo == null || devInfo.getAccId() == null || devInfo.getAccId().equals("")) {
			res.setStatus("Error");
			res.setErrorMessage("Need to login Nokia accont.");
			return res;
		}

		try {
			bookmarkService.Delete(body.gettoDeleteBookmarkIdArr(), devInfo.getAccId());
		} catch (Exception e){
			logger.error(e.getMessage());
			res.setStatus("Error");
			res.setErrorMessage("Failed to delete bookmarks.");
			res.setData(body.gettoDeleteBookmarkIdArr());
			return res;
		}

		return res;
	}
}