package dev.MehmetASLANTAS.qrcode.service;


/**
 * QrCode Service Interface Class
 *
 * @author <a href="https://github.com/aslantasmehmet">Mehmet ASLANTAŞ</a>
 * @since 1.0.0
 */
public interface QRCodeService {
	
	
	/**
	   * Generate QR Code according to the given request.
	   *
	   * @author <a href="https://github.com/aslantasmehmet">Mehmet ASLANTAŞ</a>
	   * @since 1.0.0
	   */
	byte[] generateQRCode(String qrContent,int width,int height);
	

}
