import com.scm.web.RestfulController;
import com.scm.web.SampleController;
import org.springframework.boot.SpringApplication;

/**
 * Created by admin on 2017-06-14.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Object[] clazz = {SampleController.class,RestfulController.class};
        SpringApplication.run(clazz, args);
    }
}
