package com.scm.web; /**
 * Created by admin on 2017-06-14.
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@EnableAutoConfiguration*/
@RestController
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World11!";
    }
}