package com.aka.prototicket.model.mapping;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aka.prototicket.model.dto.*;
import com.aka.prototicket.db.entity.*;

@Component
public class UserMapper
{	
	@Autowired 
	DozerBeanMapper mapper;
	 
	public UserDto toDto(User user)
	{
		UserDto dto =  mapper.map(user, UserDto.class);
		return dto;
	}
	
	public User toEntity(UserDto userDto)
	{
		User entity = mapper.map(userDto, User.class);
		return entity;
	}
}
