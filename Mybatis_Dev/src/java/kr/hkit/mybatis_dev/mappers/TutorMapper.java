package kr.hkit.mybatis_dev.mappers;

import kr.hkit.mybatis_dev.dto.Tutor;

public interface TutorMapper {
	Tutor findTutorById(int tutorId);
}
