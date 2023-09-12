package com.icebear2n2.todayhouse.avatar.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.ExistNickNameException;
import com.icebear2n2.todayhouse.config.exception.UserNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.user.User;
import com.icebear2n2.todayhouse.domain.request.avatar.AvatarRequest;
import com.icebear2n2.todayhouse.domain.response.avatar.AvatarByLikeResponse;
import com.icebear2n2.todayhouse.domain.response.avatar.AvatarByPostResponse;
import com.icebear2n2.todayhouse.domain.response.avatar.AvatarByScrapResponse;
import com.icebear2n2.todayhouse.domain.response.avatar.AvatarResponse;
import com.icebear2n2.todayhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final UserRepository userRepository;

//    TODO: Avatar CRUD

    //    TODO: Avatar CREATE
    public void insert(AvatarRequest request) {
        User user = userRepository.findById(request.userId()).orElseThrow(UserNotFoundException::new);
        Avatar avatar = request.toEntity(user);
        Boolean existsByNickname = avatarRepository.existsByNickname(avatar.getNickname());

        if (!existsByNickname) {
            avatarRepository.save(avatar);
        } else {
            throw new ExistNickNameException();
        }
    }

//    TODO: Avatar READ

    public Page<AvatarResponse> getAll(PageRequest request) {
        Page<Avatar> all = avatarRepository.findAll(request);
        return all.map(AvatarResponse::new);
    }

    public Page<AvatarByPostResponse> getPostsById(Long avatarId, PageRequest request) {
        Page<Avatar> allByAvatarId = avatarRepository.findAllByAvatarId(avatarId, request);
        return allByAvatarId.map(AvatarByPostResponse::new);
    }

    public Page<AvatarByLikeResponse> getLikesById(Long avatarId, PageRequest request) {
        Page<Avatar> allByAvatarId = avatarRepository.findAllByAvatarId(avatarId, request);
        return allByAvatarId.map(AvatarByLikeResponse::new);
    }

    public Page<AvatarByScrapResponse> getScrapsById(Long avatarId, PageRequest request) {
        Page<Avatar> allByAvatarId = avatarRepository.findAllByAvatarId(avatarId, request);
        return allByAvatarId.map(AvatarByScrapResponse::new);
    }

    //    TODO: Avatar UPDATE
    public AvatarResponse update(Long avatarId, AvatarRequest request) {
        Avatar avatar = avatarRepository.findById(avatarId).orElseThrow(AvatarNotFoundException::new);
        avatar.UpdateAvatar(request.nickname(), request.gender(), request.picture(), request.about());
        avatarRepository.save(avatar);
        return new AvatarResponse(avatar);
    }

    //    TODO: Avatar DELETE
    public void delete(Long avatarId) {
        avatarRepository.deleteById(avatarId);
    }

}
