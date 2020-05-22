package com.cherry.eshop;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cherry.eshop.model.Producto;
import com.cherry.eshop.controller.dao.ProductoDao;

@Controller
public class FirstController {

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public String greeting(Model model) {
		List<Producto> productos = ProductoDao.showAll();
		model.addAttribute("productos", productos);
		return "greeting";
	}

}
