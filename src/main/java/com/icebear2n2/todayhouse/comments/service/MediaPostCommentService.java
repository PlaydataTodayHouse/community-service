package com.icebear2n2.todayhouse.comments.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.CommentNotFoundException;
import com.icebear2n2.todayhouse.config.exception.MediaPostNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.comments.MediaPostComment;
import com.icebear2n2.todayhouse.domain.request.comments.MediaPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.comments.MediaPostCommentResponse;
import com.icebear2n2.todayhouse.posts.repository.MediaPostRepository;
import com.icebear2n2.todayhouse.comments.repository.MediaPostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaPostCommentService {
    private final MediaPostCommentRepository mediaPostCommentRepository;
    private final AvatarRepository avatarRepository;
    private final MediaPostRepository mediaPostRepository;

    //    TODO: Comment CRUD
//    TODO: Comment CREATE
    public void insert(MediaPostCommentRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        MediaPost mediaPost = mediaPostRepository.findById(request.mediaPostId()).orElseThrow(MediaPostNotFoundException::new);
        MediaPostComment mediaPostComment = request.toEntity(avatar, mediaPost);
        mediaPostCommentRepository.save(mediaPostComment);
    }

    //    TODO: Comment READ
    public Page<MediaPostCommentResponse> getAll(PageRequest request) {
        Page<MediaPostComment> all = mediaPostCommentRepository.findAll(request);
        return all.map(MediaPostCommentResponse::new);
    }

    //    TODO: Comment UPDATE
    public MediaPostCommentResponse update(Long mediaPostCommentId, MediaPostCommentRequest request) {
        MediaPostComment mediaPostComment = mediaPostCommentRepository.findById(mediaPostCommentId).orElseThrow(CommentNotFoundException::new);
        mediaPostComment.updateMediaPostComment(request.content());
        mediaPostCommentRepository.save(mediaPostComment);
        return new MediaPostCommentResponse(mediaPostComment);
    }

    //    TODO: Comment DELETE
    public void delete(Long mediaPostCommentId) {
        MediaPostComment mediaPostComment = mediaPostCommentRepository.findById(mediaPostCommentId).orElseThrow(CommentNotFoundException::new);
        mediaPostCommentRepository.deleteById(mediaPostComment.getMediaPostCommentId());
    }
}
