package com.proxym.api.controller;

import com.proxym.api.BoApplicationAttributes;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author med-amine.ben-ahmed
 *
 */
@Controller
@ManagedBean
@Slf4j
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);



	@GetMapping(value = { "/docs", "" })
	@ResponseBody
	public String docs(@RequestParam Optional<String> error) {
		LOGGER.error("you visited docs ");

		return "hi to docs";

	}


	@Value("${server.contextPath}")
	private String contextPath;



	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		LOGGER.info("[LoginController] logout ");
		HttpSession session = request.getSession(false);
		if (request.isRequestedSessionIdValid() && session != null) {
			session.invalidate();
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/faq")
	public ModelAndView welcome() {
		LOGGER.info("[LoginController] wellcome ");


		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/dashboard");
		//terminals = restclient.getAllTerminals();
		return modelView;
	}


	public void logout() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect(BoApplicationAttributes.getContextPath()+"/logout");
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}


}
