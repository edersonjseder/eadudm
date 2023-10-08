package com.ead.udm.course.utils;

import com.ead.udm.course.dtos.SubscriptionDto;
import com.ead.udm.course.dtos.UserDto;
import com.ead.udm.course.models.Course;
import com.ead.udm.course.models.CourseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseUserUtils {
    private final CourseUtils courseUtils;
    public CourseUser toCourseUser(SubscriptionDto subscriptionDto, Course course) {
        return CourseUser.builder()
                .userId(subscriptionDto.getUserId())
                .course(course)
                .build();
    }

    public SubscriptionDto toSubscriptionDto(CourseUser courseUser, UserDto user) {
        return SubscriptionDto.builder()
                .userCourseId(courseUser.getId())
                .userId(courseUser.getUserId())
                .user(user)
                .course(courseUtils.toCourseDto(courseUser.getCourse()))
                .build();
    }
}
