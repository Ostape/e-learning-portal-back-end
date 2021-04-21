package com.robosh.ejournal.data.mapper;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserDtoToUser(UserDto userDto);

    UserDto fromUserToUserDto(User user);
}


//@Mapper(componentModel = "spring")
//public interface AdminMapper {
//
//    @Mapping(target = "password", ignore = true)
//    Admin fromAdminInfoDtoToAdmin(AdminInfoDto adminDto);
//
//    AdminInfoDto fromAdminToAdminInfoDto(Admin admin);
//
//    Admin fromSaveAdminDtoToAdmin(SaveAdminDto saveAdminDto);
//
//    List<AdminInfoDto> fromAdminsToAdminsInfoDto(List<Admin> admins);
//}