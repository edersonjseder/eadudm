package com.ead.udm.course.specifications;

import com.ead.udm.course.models.Lesson;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Spec(path="title", spec= Like.class)
public interface LessonSpec extends Specification<Lesson> {
}
