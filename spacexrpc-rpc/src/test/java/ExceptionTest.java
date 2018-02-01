
/*
异常分类

受检异常，非受检异常（runtime异常）。

异常throw与处理建议

抛出

thow在函数内抛出； throws在函数声明里抛出。

如果是受检异常且在throws里抛出，那么调用方必须显式的try，catch，否则代码编译不通过。

非受检异常，也即runtime异常，java默认在throws抛出，不用try也能编译通过。

建议所有throw都在方法声明处throws。

处理

受检异常，限制必须在方法签名上throws或者在方法体内处理。

自己不处理，必须向上抛出。如果是运行时异常，不抛出（默认thows，会一层一层向上抛出），如果都不处理，则进程被杀死。

代码

*/

class Calculate {
    public static int div(int a, int b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}

public class ExceptionTest {
    public static void main(String[] args) {
        //Calculate.div(3,0);
    }
}
