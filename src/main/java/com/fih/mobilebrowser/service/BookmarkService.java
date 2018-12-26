package com.fih.mobilebrowser.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fih.mobilebrowser.entities.Bookmark;
import com.fih.mobilebrowser.repository.curd.BookmarkCurdRepository;

@Service
public class BookmarkService {

	@Autowired
	BookmarkCurdRepository bookmarkCurdRepo;

	public List<Bookmark> Get(String AccId) throws Exception {
		return bookmarkCurdRepo.findByAccIdOrderByCreatedDateAscIdAsc(AccId);
	}

	public Iterable<Bookmark> Upload(Iterable<Bookmark> bookmarks, String AccId) throws Exception {
		Iterable<Bookmark> it = bookmarks;
		for (Bookmark bookmark : it) {
			bookmark.setid(null);
			bookmark.setaccId(AccId);
			bookmark.setcreatedDate(new Date());
			bookmark.setmodifiedDate(new Date());
		}
		return bookmarkCurdRepo.saveAll(bookmarks);
	}

	public void Update(List<Bookmark> bookmarks, String AccId) throws Exception {
		List<Bookmark> list = new ArrayList<>();
		for (Bookmark bookmark : bookmarks) {
			List<Bookmark> oldBookMarkList = bookmarkCurdRepo.findByIdAndAccId(bookmark.getid(), AccId);
			if (oldBookMarkList.size() != 1) {
				throw new Exception("Failed to update.");
			}
			Bookmark oldBookmark = oldBookMarkList.get(0);
			oldBookmark.setname(bookmark.getname() == null ? oldBookmark.getname() : bookmark.getname());
			oldBookmark.setwebUrl(bookmark.getwebUrl() == null ? oldBookmark.getwebUrl() : bookmark.getwebUrl());
			oldBookmark.seticonUrl(bookmark.geticonUrl() == null ? oldBookmark.geticonUrl() : bookmark.geticonUrl());
			oldBookmark.setmodifiedDate(new Date());
			list.add(oldBookmark);
		}
		bookmarkCurdRepo.saveAll(list);
	}

	public void Delete(Long[] ids, String AccId) throws Exception {
		List<Bookmark> list = new ArrayList<>();
		for (long id : ids) {
			List<Bookmark> oldBookMarkList = bookmarkCurdRepo.findByIdAndAccId(id, AccId);
			if (oldBookMarkList.size() != 1) {
				throw new Exception("Failed to delete bookmarks.");
			}
			Bookmark oldBookmark = oldBookMarkList.get(0);
			list.add(oldBookmark);
		}
		bookmarkCurdRepo.deleteAll(list);
	}
}
