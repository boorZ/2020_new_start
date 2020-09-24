//package exceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.servlet.http.HttpServletRequest;
//import java.nio.file.AccessDeniedException;
//
///**
// * @author 周林
// * @Description 异常处理类，方便对各种类型的异常进行抛出
// * 针对不同的异常自定义不同的方法
// * * 环绕通知
// * * 切面:针对所有的controller中抛出的异常
// * * 若使用@ControllerAdvice,则不会自动转换为JSON格式
// * @email prometheus@noask-ai.com
// * @date 2020/9/21 11:42
// */
//@RestControllerAdvice
//public class RestExceptionHandler {
//    /**
//     * 业务异常处理
//     *
//     * @param e
//     * @return MyTestException
//     */
//    @ExceptionHandler({MyTestException.class})
//    public ResponseEntity<MyTestException> businessExceptionHandler(HttpServletRequest request, MyTestException e) throws MyTestException {
//        return new ResponseEntity(new MyTestException(e.getCode(), e.getMessage()), HttpStatus.CONFLICT);
//    }
//
//    /**
//     * 业务异常处理
//     *
//     * @param e
//     * @return MyTestException
//     */
//    @ExceptionHandler({AccessDeniedException.class})
//    public ResponseEntity<MyTestException> BusinessExceptionHandler(HttpServletRequest request, AccessDeniedException e) throws MyTestException {
//        return new ResponseEntity(new MyTestException(401, e.getMessage()), HttpStatus.UNAUTHORIZED);
//    }
//
//    /**
//     * 只要抛出该类型异常,则由此方法处理
//     * 并由此方法响应出异常状态码及消息
//     * 如:RoleController.getRoleById(String id)方法
//     *
//     * @param request
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<MyTestException> handleException(HttpServletRequest request, Exception e) throws Exception {
//
//        MyTestException body = new MyTestException();
//        body.setCode(500);
//        body.setMessage(e.getMessage());
//
//        //可以根据公司情况不同，类似的异常可能需要不同的状态码
//        ResponseEntity<MyTestException> responseEntity = new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//        return responseEntity;
//    }
//}
