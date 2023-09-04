package com.bilgeadam.utility;

import com.bilgeadam.dto.response.UserProfileFindAllResponseDto;
import com.bilgeadam.manager.IUserManager;
import com.bilgeadam.mapper.IElasticMapper;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllData {

    private final IUserManager userManager;

    private final UserService userService;

    // @PostConstruct
    public void initData() {

        List<UserProfileFindAllResponseDto> list = userManager.findAll().getBody();

        // List<UserProfile>

        userService.saveAll(IElasticMapper.INSTANCE.toUserProfiles(list));
    }
}