package com.icebear2n2.todayhouse.user.service;

import com.icebear2n2.todayhouse.domain.dto.user.UserDto;
import com.icebear2n2.todayhouse.domain.entity.user.User;
import com.icebear2n2.todayhouse.domain.request.user.SignupRequest;
import com.icebear2n2.todayhouse.domain.request.user.UserRequest;
import com.icebear2n2.todayhouse.domain.response.user.SignupResponse;
import com.icebear2n2.todayhouse.user.config.TokenInfo;
import com.icebear2n2.todayhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserRequest request){
        return userRepository.save(request.toEntity());
    }

    public SignupResponse checkSignup(TokenInfo tokenInfo){
        User user = getByToken(tokenInfo);
        return SignupResponse.builder()
                .user(new UserDto(user))
                .redirect(user.getAddress()==null
                        ? "/signup" : "/main")
                .build();
    }

    @Transactional
    public SignupResponse signup(SignupRequest request, TokenInfo tokenInfo){
        User user = getByToken(tokenInfo);
        user.UpdateAddress(request.getAddress());
        return SignupResponse.builder()
                .user(new UserDto(user))
                .redirect("/main")
                .build();
    }

    public User getMe(TokenInfo tokenInfo){
        return getById(tokenInfo.getId());
    }

    public User getById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("NOT EXIST"));
    }




    private User getByToken(TokenInfo tokenInfo){
        UUID id = tokenInfo.getId();
        Optional<User> byId = userRepository.findById(id);
        if(byId.isEmpty()){
            UserRequest userRequest =
                    new UserRequest(id
                            , tokenInfo.getName()
                            , tokenInfo.getNumber());
            return save(userRequest);
        }else{
            return byId.get();
        }
    }
}
