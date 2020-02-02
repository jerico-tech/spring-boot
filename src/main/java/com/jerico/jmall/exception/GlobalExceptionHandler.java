//package com.jerico.jmall.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * @className: ExceptionHandler
// * @description:
// * @author: jerico
// * @date: 2019-10-11 23:31
// * @version:
// */
//@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//    /**
//     * 拦截Exception类的异常
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Map<String, Object> exceptionHandler(Exception e) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("respCode", "9999");
//        result.put("respMsg", e.getMessage());
//        //正常开发中，可创建一个统一的相应实体；
//        return result;
//    }
//
//    /**
//     * 当方法参数不是预期类型时，抛出MethodArgumentTypeMismatchException异常，我们构造ApiErrorResponse类嵌入ResponseEntity返回
//     * @param ex
//     * @param headers
//     * @param status
//     * @param request
//     * @return
//     */
//    @Override
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatus status,
//                                                                  WebRequest request) {
//        ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
//                        .withStatus(status)
//                        .withErrorCode(HttpStatus.BAD_REQUEST.name())
//                        .withMessage(ex.getLocalizedMessage())
//                        .withDetail("")
//                        .build();
//        return new ResponseEntity<>(response, response.getStatus());
//    }
//
//    /**
//     * 当API无法读取HTTP消息时，抛出HttpMessageNotReadable异常
//     * @param ex
//     * @param headers
//     * @param status
//     * @param request
//     * @return
//     */
//    @Override
//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String error = "Malformed JSON request ";
//        ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
//                .withStatus(status)
//                .withError_code("BAD_DATA")
//                .withMessage(ex.getLocalizedMessage())
//                .withDetail(error + ex.getMessage()).build();
//        return new ResponseEntity<>(response, response.getStatus());
//    }
//
//    /**
//     * 处理自定义异常，将自定义异常返回给客户端API。
//     *
//     * 看一个简单的用例，当客户端API通过其唯一ID调用后端存储库查找记录时，如果找不到该记录，我们的存储库类会返回null或空对象，在这种情况下，即使找不到我们想要的资源记录，API也会向客户端返回http 200
//     * (OK响应。 为了处理所有类似这样的情况，我们创建了一个自定义异常，并在全局异常处理器GlobalRestExceptionHandler中实现。
//     * @param ex
//     * @param headers
//     * @param status
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(CustomServiceException.class)
//    protected ResponseEntity<Object> handleCustomAPIException(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
//                .withStatus(status)
//                .withErrorCode(HttpStatus.NOT_FOUND.name())
//                .withMessage(ex.getLocalizedMessage())
//                .withDetail(ex.getMessage())
//                .build();
//        return new ResponseEntity<>(response, response.getStatus());
//    }
//
//
//
//
//    }
