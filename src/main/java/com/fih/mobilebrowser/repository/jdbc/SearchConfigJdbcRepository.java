package com.fih.mobilebrowser.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fih.mobilebrowser.models.SearchConfig;

@Repository("SearchConfigJdbcRepository")
public class SearchConfigJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<SearchConfig> getSearchConfig(String ModelName) {

		String qStr = "EXEC MobileBrowser.dbo.sp_GetSearchConfig @Prj = ?";

		Object[] args = new Object[] { ModelName };
		int[] argTypes = new int[] { Types.VARCHAR };

		List<SearchConfig> rows = jdbcTemplate.query(qStr, args, argTypes, new RowMapper<SearchConfig>() {
			@Override
			public SearchConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchConfig searchConfig = new SearchConfig();
				searchConfig.setName(rs.getString(1));
				searchConfig.setSearchUrl(rs.getString(2));
				searchConfig.setHotWordUrl(rs.getString(3));
				searchConfig.setSearchWordUrl(rs.getString(4));
				searchConfig.setBid(rs.getString(5));
				searchConfig.setPid(rs.getString(6));
				searchConfig.setCid(rs.getString(7));
				return searchConfig;
			}
		});

		return rows;
	}
}
