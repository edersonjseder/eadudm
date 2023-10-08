package com.ead.udm.course.utils;

import com.ead.udm.course.dtos.LessonDto;
import com.ead.udm.course.models.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonUtils {
    private final DateUtils dateUtils;
    private final ModuleUtils moduleUtils;

    public LessonDto toLessonDto(Lesson lesson) {
        return LessonDto.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .videoUrl(lesson.getVideoUrl())
                .creationDate(dateUtils.parseDate(lesson.getCreationDate()))
                .module(moduleUtils.toModuleDto(lesson.getModule()))
                .build();
    }

    public Page<LessonDto> toListLessonDto(Page<Lesson> lessons) {
        return lessons.map(lesson -> LessonDto.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .videoUrl(lesson.getVideoUrl())
                .creationDate(dateUtils.parseDate(lesson.getCreationDate()))
                .module(moduleUtils.toModuleDto(lesson.getModule()))
                .build());
    }
}
