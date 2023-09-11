package com.icebear2n2.todayhouse.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(ExistEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existEmailExceptionHandler(ExistEmailException e) {
        return new ErrorResponse("The EMAIL ALREADY EXIST.", e.getCause());
    }

    @ExceptionHandler(ExistNickNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existNickNameExceptionHandler(ExistNickNameException e) {
        return new ErrorResponse("NICKNAME ALREADY EXIST.", e.getCause());
    }

    @ExceptionHandler(ExistAvatarUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existAvatarUserExceptionHandler(ExistAvatarUserException e) {
        return new ErrorResponse("USER AND AVATAR HAVE ALREADY BEEN CONNECTED!!", e.getCause());
    }

    @ExceptionHandler(ExistFollowException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existFollowExceptionHandler(ExistFollowException e) {
        return new ErrorResponse("ALREADY CONNECTED TO FOLLOW!!", e.getCause());
    }

    @ExceptionHandler(ExistLikeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existLikeExceptionHandler(ExistLikeException e) {
        return new ErrorResponse("ALREADY LIKE POST!!", e.getCause());
    }

    @ExceptionHandler(ExistScrapException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse existScrapExceptionHandler(ExistScrapException e) {
        return new ErrorResponse("ALREADY SCRAP POST!!", e.getCause());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFoundHandler(UserNotFoundException e) {
        return new ErrorResponse("THE USER NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(AvatarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse avatarNotFoundHandler(AvatarNotFoundException e) {
        return new ErrorResponse("THE AVATAR NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(HouseTourNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse houseTourNotFoundHandler(HouseTourNotFoundException e) {
        return new ErrorResponse("HOUSE TOUR POST NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(MediaPostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse mediaPostNotFoundHandler(MediaPostNotFoundException e) {
        return new ErrorResponse("MEDIA POST NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(TipPostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse tipPostNotFoundHandler(TipPostNotFoundException e) {
        return new ErrorResponse("TIP POST NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(FollowNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse followNotFoundHandler(FollowNotFoundException e) {
        return new ErrorResponse("FOLLOW RELATIONSHIP NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse commentNotFoundHandler(CommentNotFoundException e) {
        return new ErrorResponse("COMMENT NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(LikeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse likeNotFoundHandler(LikeNotFoundException e) {
        return new ErrorResponse("LIKE NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(ScrapNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse scrapNotFoundHandler(ScrapNotFoundException e) {
        return new ErrorResponse("SCRAP NOT FOUND!!", e.getCause());
    }

    @ExceptionHandler(NotAllowFollowException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse notAllowFollowExceptionHandler(NotAllowFollowException e) {
        return new ErrorResponse("YOU CAN'T FOLLOW YOURSELF.", e.getCause());
    }
}
