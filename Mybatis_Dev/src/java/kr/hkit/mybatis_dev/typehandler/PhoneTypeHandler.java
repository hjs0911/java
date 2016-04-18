package kr.hkit.mybatis_dev.typehandler;

import kr.hkit.mybatis_dev.dto.PhoneNumber;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int parameterIndex, PhoneNumber parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(parameterIndex, parameter.toString());
		
	}

}
