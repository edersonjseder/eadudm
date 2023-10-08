package com.ead.udm.course.errorhandler;

import com.ead.udm.course.exceptions.AuthUserServiceNotAvailableException;
import com.ead.udm.course.exceptions.BadRequestException;
import com.ead.udm.course.exceptions.CourseUserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static com.ead.udm.course.constants.CourseMessagesConstants.COURSE_USER_NOT_FOUND_MENSAGEM;
import static com.ead.udm.course.constants.CourseMessagesConstants.COURSE_USER_SERVICE_MENSAGEM;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 400 -> new BadRequestException();
            case 404 -> new CourseUserNotFoundException(COURSE_USER_NOT_FOUND_MENSAGEM);
            case 503 -> new AuthUserServiceNotAvailableException(COURSE_USER_SERVICE_MENSAGEM);
            default -> new Exception("Exception while getting details");
        };
    }
}
