package kr.hkit.mybatis_dev.mappers;

import kr.hkit.mybatis_dev.dto.Address;

public interface AddressMapper {
	Address findAddressResult(int addrId);
}
