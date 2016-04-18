package kr.hkit.mybatis_dev.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.hkit.mybatis_dev.dto.Address;
import kr.hkit.mybatis_dev.mappers.AddressMapper;
import kr.hkit.mybatis_dev.util.MybatisSqlSessionFactory;

public class AddressService {
	private static final Logger logger = Logger.getLogger(StudentService.class);

	private static final AddressService instance = new AddressService();

	public static AddressService getInstance() {
		return instance;
	}

	private AddressService() {
	}

	public Address findAddressResult(int addrId) {
		logger.debug("findAddressResult()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try {
			AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
			return addressMapper.findAddressResult(addrId);
		} finally {
			sqlSession.close();
		}

	}

}
