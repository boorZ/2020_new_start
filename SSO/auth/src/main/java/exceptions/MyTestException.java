package exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 周林
 * @Description 自定义异常
 * @email prometheus@noask-ai.com
 * @date 2020/9/21 11:33
 */

//@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
@Setter
@Getter
@NoArgsConstructor
//此处可以换成其他的异常列：NumberFormatException，ArithmeticException，RuntimeException
public class MyTestException extends Exception {
    public MyTestException(String msg) {
        //此处传入的是抛出异常后显示的信息提示
        super(msg);
    }
}
