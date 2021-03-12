package org.comstudy21.webapp;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaramController {

	@RequestMapping(value = "/saram/list.do", method = RequestMethod.GET)
	public String saramList() {

		return "saram/list";
	}

	@RequestMapping(value = "/saram/input.do", method = RequestMethod.GET)
	public String saramInput() {
		return "saram/input";
	}

	@RequestMapping(value = "/saram/input.do", method = RequestMethod.POST)
	public String saramInputAction(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String age = req.getParameter("age");

		System.out.println("name =>" +name);
		System.out.println("age =>" +age);

		
		
		return "redirect:list.do";
	}
}
