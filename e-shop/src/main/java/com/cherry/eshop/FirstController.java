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
		String content = "";
		int count = 0;
		for (Producto producto : productos) {
			if (count % 4 == 0)
				content += "<div class=\"row d-flex flex-row justify-content m-3\">";
			content += "<div class=\"col\"><div class=\"card\" style=\"width: 18rem;\"><img src=\"img/"
					+ producto.getImagen()
					+ "\" class=\"card-img-top\" alt=\"...\"><div class=\"card-body bg-info text-white text-center\"><h5 class=\"card-title\">"
					+ producto.getNombre() + "</h5><br><label class=\"col col-form-label\">$ " + producto.getPrecio()
					+ "</label><div class=\"form-group row\"><label class=\"col col-form-label\">Cantidad</label><div class=\"col\"><input type=\"number\" id=\"cantidad"
					+ count
					+ "\" class=\"form-control\" min=\"0\" step=\"1\" value=\"0\"></div></div></div></div></div>";
			if (count % 4 - 1 == 0)
				content += "</div>";
			count++;
		}
		for (int i = count % 4; i < 4 && i != 0; i++) {
			content += "<div class=\"col\"></div>";
			if (i == 3)
				content += "</div>";
		}
		model.addAttribute("content", content);
		return "greeting";
	}

}
