package com.ead.udm.course.utils;

import com.ead.udm.course.dtos.ModuleDto;
import com.ead.udm.course.models.Module;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModuleUtils {
    private final DateUtils dateUtils;
    private final CourseUtils courseUtils;

    public ModuleDto toModuleDto(Module module) {
        return ModuleDto.builder()
                .id(module.getId())
                .title(module.getTitle())
                .description(module.getDescription())
                .creationDate(dateUtils.parseDate(module.getCreationDate()))
                .course(courseUtils.toCourseDto(module.getCourse()))
                .build();
    }

    public Page<ModuleDto> toListModuleDto(Page<Module> modules) {
        return modules.map(module -> ModuleDto.builder()
                .id(module.getId())
                .title(module.getTitle())
                .description(module.getDescription())
                .creationDate(dateUtils.parseDate(module.getCreationDate()))
                .build());
    }
}
