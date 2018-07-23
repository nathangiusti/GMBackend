package com.nathangiusti.gmbackend;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RecordMapper implements RowMapper<Record>{
	
	public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Record record = new Record();
	
		record.setCreatedDate(rs.getDate("created_dt").toLocalDate());
		record.setClient(rs.getString("client"));
		record.setProject(rs.getString("project"));
		record.setProjectCode(rs.getString("project_code"));
		record.setTask(rs.getString("task"));
		record.setHours(rs.getBigDecimal("hours"));
		record.setHoursRounded(rs.getBigDecimal("hours_rounded"));
		record.setBillable(rs.getBoolean("billable"));
		record.setInvoiced(rs.getBoolean("invoiced"));
		record.setApproved(rs.getBoolean("approved"));
		record.setFirstName(rs.getString("first_name"));
		record.setLastName(rs.getString("last_name"));
		record.setDepartment(rs.getString("department"));
		record.setBillablerate(rs.getInt("billable_rate"));
		record.setEmployee(rs.getBoolean("employee"));
		record.setCostRate(rs.getInt("cost_rate"));
		record.setCostAmmount(rs.getInt("cost_amount"));
		record.setCurrency(rs.getString("currency"));
		record.setUrl(rs.getString("url"));
		
		return record;
	}
	

}
