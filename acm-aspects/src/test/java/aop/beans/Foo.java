package aop.beans;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.acm.annotations.Loggable;

@Loggable(prepend = true, value = Loggable.DEBUG, limit = 1, unit = TimeUnit.SECONDS, name = "test")
@Service("foo")
public class Foo implements IFoo {
    // @Loggable(prepend = true, value = Loggable.DEBUG, limit = 2, unit =
    // TimeUnit.SECONDS)
    @Override
    public double power(int x, int p) {
        try {
            Thread.sleep(12000l);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block

        }
        return Math.pow(x, p);
    }

    // @Loggable(prepend = true, value = Loggable.DEBUG, limit = 2, unit =
    // TimeUnit.SECONDS)
    public String power1(@Valid Map<Object, Object> map, @NotNull String name) {
        return map + name;
    }

    // @Loggable(prepend = true, value = Loggable.DEBUG, limit = 2, unit =
    // TimeUnit.SECONDS, logThis = true)
    public String power2(@Valid Object Obj, @NotNull String name) {
        return Obj + name;
    }

    // @Loggable(prepend = true, value = Loggable.DEBUG, limit = 2, unit =
    // TimeUnit.SECONDS)
    @Override
    public String toString() {
        return super.toString();
    }

}