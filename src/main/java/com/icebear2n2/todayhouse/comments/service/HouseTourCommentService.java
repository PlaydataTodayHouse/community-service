package com.icebear2n2.todayhouse.comments.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.comments.repository.HouseTourCommentRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.CommentNotFoundException;
import com.icebear2n2.todayhouse.config.exception.HouseTourNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourComment;
import com.icebear2n2.todayhouse.domain.request.HouseTourCommentRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourCommentResponse;
import com.icebear2n2.todayhouse.posts.repository.HouseTourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseTourCommentService {
    private final HouseTourCommentRepository houseTourCommentRepository;
    private final AvatarRepository avatarRepository;
    private final HouseTourRepository houseTourRepository;

    //    TODO: Comment CRUD
//    TODO : Comment CREATE
    public void insert(HouseTourCommentRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        HouseTour houseTour = houseTourRepository.findById(request.houseTourId()).orElseThrow(HouseTourNotFoundException::new);
        HouseTourComment houseTourComment = request.toEntity(avatar, houseTour);
        houseTourCommentRepository.save(houseTourComment);
    }

    //    TODO: Comment READ
    public Page<HouseTourCommentResponse> getAll(PageRequest request) {
        Page<HouseTourComment> all = houseTourCommentRepository.findAll(request);
        return all.map(HouseTourCommentResponse::new);
    }

    //    TODO: Comment UPDATE
    public HouseTourCommentResponse update(Long houseTourCommentId, HouseTourCommentRequest request) {
        HouseTourComment houseTourComment = houseTourCommentRepository.findById(houseTourCommentId).orElseThrow(CommentNotFoundException::new);
        houseTourComment.updateHouseTourComment(request.content());

        houseTourCommentRepository.save(houseTourComment);
        return new HouseTourCommentResponse(houseTourComment);
    }


    //    TODO: Comment DELETE
    public void delete(Long houseTourCommentId) {
        HouseTourComment houseTourComment = houseTourCommentRepository.findById(houseTourCommentId).orElseThrow(CommentNotFoundException::new);
        houseTourCommentRepository.deleteById(houseTourComment.getHouseTourCommentId());
    }
}
