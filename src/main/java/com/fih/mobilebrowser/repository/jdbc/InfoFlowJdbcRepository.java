package com.fih.mobilebrowser.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fih.mobilebrowser.models.InfoFlow;

@Repository("InfoFlowRepository")
public class InfoFlowJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<InfoFlow> getInfoFlow(String ModelName) {

		String qStr = "EXEC MobileBrowser.dbo.sp_GetInfoFlow @Prj = ?";

		Object[] args = new Object[] { ModelName };
		int[] argTypes = new int[] { Types.VARCHAR };

		List<InfoFlow> rows = jdbcTemplate.query(qStr, args, argTypes, new RowMapper<InfoFlow>() {
			@Override
			public InfoFlow mapRow(ResultSet rs, int rowNum) throws SQLException {
				InfoFlow infoFlow = new InfoFlow();
				infoFlow.setName(rs.getString(1));
				infoFlow.setChannelUrl(rs.getString(2));
				infoFlow.setNewsUrl(rs.getString(3));
				infoFlow.setApiKey(rs.getString(4));
				infoFlow.setApiSecret(rs.getString(5));
				infoFlow.setBid(rs.getString(6));
				return infoFlow;
			}  
		});

		return rows;
	}
}
