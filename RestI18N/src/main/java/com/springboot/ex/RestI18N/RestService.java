package com.springboot.ex.RestI18N;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Rest Controller Class
 * 
 * @author Udhay
 *
 */
@RestController
@RequestMapping(path="i18n")
public class RestService {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/")
	public String sayGoodMorning(@RequestHeader(name="Accept-Language", required= false) Locale locale){	
		System.out.println("Locale :" + locale.getDisplayName());
		return  messageSource.getMessage("good.morning.msg", null, locale);
	}
}
