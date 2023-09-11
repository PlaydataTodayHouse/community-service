package com.icebear2n2.todayhouse.comments.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.CommentNotFoundException;
import com.icebear2n2.todayhouse.config.exception.TipPostNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import com.icebear2n2.todayhouse.domain.entity.comments.TipPostComment;
import com.icebear2n2.todayhouse.domain.request.comments.TipPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.comments.TipPostCommentResponse;
import com.icebear2n2.todayhouse.posts.repository.TipPostRepository;
import com.icebear2n2.todayhouse.comments.repository.TipPostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipPostCommentService {
    private final TipPostCommentRepository tipPostCommentRepository;
    private final AvatarRepository avatarRepository;
    private final TipPostRepository tipPostRepository;

    //    TODO: Comment CRUD
//    TODO: Comment CREATE
    public void insert(TipPostCommentRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        TipPost tipPost = tipPostRepository.findById(request.tipPostId()).orElseThrow(TipPostNotFoundException::new);
        TipPostComment tipPostComment = request.toEntity(avatar, tipPost);
        tipPostCommentRepository.save(tipPostComment);
    }

    //    TODO: Comment READ
    public Page<TipPostCommentResponse> getAll(PageRequest request) {
        Page<TipPostComment> all = tipPostCommentRepository.findAll(request);
        return all.map(TipPostCommentResponse::new);
    }

    //    TODO: Comment UPDATE
    public TipPostCommentResponse update(Long tipPostCommentId, TipPostCommentRequest request) {
        TipPostComment tipPostComment = tipPostCommentRepository.findById(tipPostCommentId).orElseThrow(CommentNotFoundException::new);
        tipPostComment.updateTipPostComment(request.content());
        return new TipPostCommentResponse(tipPostComment);
    }

    //    TODO: Comment DELETE
    public void delete(Long tipPostCommentId) {
        TipPostComment tipPostComment = tipPostCommentRepository.findById(tipPostCommentId).orElseThrow(CommentNotFoundException::new);
        tipPostCommentRepository.deleteById(tipPostComment.getTipPostCommentId());
    }
}
