package com.icebear2n2.todayhouse.domain.request.posts;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;

public record HouseTourRequest(Long avatarId, String housingType, Integer roomCount, String direction, String location,
                               String familyType, Boolean petPresence, Integer familyCount, String workField,
                               String worker, String duration, Integer budget, String copyrightNotice, String title,
                               String content) {

    public HouseTour toEntity(Avatar avatar) {
        return HouseTour.builder().housingType(housingType)
                .roomCount(roomCount)
                .direction(direction)
                .location(location)
                .familyType(familyType)
                .petPresence(petPresence)
                .familyCount(familyCount)
                .workField(workField)
                .worker(worker)
                .duration(duration)
                .budget(budget)
                .copyrightNotice(copyrightNotice)
                .title(title)
                .content(content)
                .avatar(avatar)
                .build();
    }
}
