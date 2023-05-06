package com.cyobject.black_company_top.common.config;

import com.cyobject.black_company_top.common.enums.ApiStateEnum;
import com.cyobject.black_company_top.common.utils.APIResult;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * java.sql.SQLSyntaxErrorException进行捕获发现使用其父类java.sql.SQLException无法实现，
 * 若使用java.sql.Exception进行捕获可以实现但异常定位将不准确，
 * 后经过了解发现Spring只支持抛出org.springframework.dao.DataAccessException异常，
 * 该异常与实际异常java.sql.SQLSyntaxErrorException父类不相同，因此无法捕获
 */

/**
 * 一个异常的抛出并不一定以其本身或超类的形式传递，
 * 因此要捕获该异常不可绝对的认为用其本身或超类可以捕获，
 * 也不可笼统的使用java.lang.Exception，追根溯源，找到其准确的传递形式才能正确的捕获并定位该异常
 */
@RestControllerAdvice
public class GlobalExceptionConfig {

    //其他异常
    @ExceptionHandler(Exception.class)
    public APIResult exceptionHandler(Exception exception) {
        return APIResult.error().data(exception.getMessage()).message(ApiStateEnum.OTHER_ERROR.getMessage());
    }

    //自定义异常
    @ExceptionHandler(HttpException.class)
    public APIResult exceptionHandler(HttpException httpException) {
        Integer httpStatusCode = httpException.getHttpStatusCode();
        APIResult apiResult = new APIResult();
        switch (httpStatusCode) {
            case 400: {
                apiResult.parameter().data(httpException.getErrorCode()).message(httpException.getErrorMessage());
            }
            case 404: {
                apiResult.notFound().data(httpException.getErrorCode()).message(httpException.getErrorMessage());
            }
            case 500: {
                apiResult.error().data(httpException.getErrorCode()).message(httpException.getErrorMessage());
            }
        }
        return apiResult;
    }

    //SQL异常
    @ExceptionHandler(DataAccessException.class)
    public APIResult handleSQLException(DataAccessException dataAccessException) {
        return APIResult.error().data(dataAccessException.getMessage()).message(ApiStateEnum.SQL_ERROR.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public APIResult handleNullPointerException(NullPointerException nullPointerException) {
        return APIResult.error().data(nullPointerException.getMessage()).message(ApiStateEnum.NULL_POINT_ERROR.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public APIResult handleBingException(BindException bindException) {
        FieldError fieldError = bindException.getBindingResult().getFieldError();
        assert fieldError != null;
        return APIResult.error().message(bindException.getBindingResult().getFieldError().getDefaultMessage());
    }

    //处理参数校验异常
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public APIResult handleValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        //将错误信息返回给前台
        return APIResult.parameter().message(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
    }

}