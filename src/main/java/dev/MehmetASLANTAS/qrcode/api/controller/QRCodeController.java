package dev.MehmetASLANTAS.qrcode.api.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.MehmetASLANTAS.qrcode.service.QRCodeService;


/**
 * REST Controller for QR Code related API end-points.
 *
 * @author <a href="https://github.com/aslantasmehmet"> Mehmet ASLANTAŞ </a>
 * @since 1.0.0
 */
@Controller
public class QRCodeController {
	
	@Autowired
	private QRCodeService qrCodeService;
	
	
	 /**
	   * REST end-point in order to generate QR code in Base64 String with POST operation.
	   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
	  
	   * @author <a href="https://github.com/aslantasmehmet">Mehmet ASLANTAŞ</a>
	   * @since 1.0.0
	   */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	/**
	   * REST end-point in order to generate QR code in Base64 String with POST operation.
	   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
	  
	   * @author <a href="https://github.com/aslantasmehmet">Mehmet ASLANTAŞ</a>
	   * @since 1.0.0
	   */
	@PostMapping("/showQRCode")
	public String showQRCode(String qrContent,Model model) {
		model.addAttribute("qrCodeContent", "/generateQRCode?qrContent=" + qrContent);
		return "show-qr-code";
		
		
	}
	
	 /**
	   * REST end-point in order to generate QR code in Base64 String with POST operation.
	   * Details related to API specs can be found in the API Documentation which can be reached as described in README file.
	  
	   * @author <a href="https://github.com/aslantasmehmet">Mehmet ASLANTAŞ</a>
	   * @since 1.0.0
	   */
	@GetMapping("/generateQRCode")
	public void generateQRCode(String qrContent,HttpServletResponse response ) throws IOException{
		response.setContentType("image/png");
		byte[] qrCode = qrCodeService.generateQRCode(qrContent, 500, 500);
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(qrCode);
		
	}

}
