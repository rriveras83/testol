package mx.com.jrrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Roberto on 03/08/2017.
 */
@Controller
public class StartController {

    @RequestMapping("/start")
    public ModelAndView start(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("start");
        return mav;
    }

}
