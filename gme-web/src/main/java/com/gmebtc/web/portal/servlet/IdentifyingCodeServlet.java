package com.gmebtc.web.portal.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmebtc.web.portal.constant.SessionAttributes;
/**
 * 验证码处理
 *
 */
public class IdentifyingCodeServlet extends HttpServlet{
	
	private static final long serialVersionUID = -8765642283107293966L;
	private static final Logger log = LoggerFactory.getLogger(IdentifyingCodeServlet.class);
	
	 // 验证码干扰线数  
    private int lineCount = 15;  
    
	private char[] dictinary = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
											'A','B','C','D','E','F','G','H','I','J','k','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		StringBuffer verifyCode = randomVerifyCode();
		ServletOutputStream sos=null;
		try {
			HttpSession session = req.getSession(true);
			session.setAttribute(SessionAttributes.VALIDATE_CODE, verifyCode.toString());
			BufferedImage outImg = new BufferedImage(100, 30,  BufferedImage.TYPE_INT_RGB);
			Graphics2D g = (Graphics2D) outImg.getGraphics();
			g.setColor(Color.WHITE);  
			g.fillRect(0, 0, 100, 30);    
			g.setFont(new Font("Dialog", Font.BOLD, 19));
			g.setPaintMode();
			Random random = new Random();  
			int red = 0, green = 0, blue = 0;  
			for (int i = 0; i < lineCount; i++) {  
	            int xs = random.nextInt(100);  
	            int ys = random.nextInt(30);  
	            int xe = xs+random.nextInt(80);  
	            int ye = ys+random.nextInt(15);  
	            red = random.nextInt(255);  
	            g.setColor(new Color(red, red, red));  
	            g.drawLine(xs, ys, xe, ye);  
	        }  
			for (int i = 0; i < verifyCode.length(); i++) {
				red = random.nextInt(110);
				green = random.nextInt(110);
				blue = random.nextInt(110);
				g.setColor(new Color(red, green, blue));
				if(i == 0){
					g.drawString(String.valueOf(verifyCode.charAt(i)), 5, 18);
				}else if( i == 1){
					g.drawString(String.valueOf(verifyCode.charAt(i)), 19, 18);
				}else{
					g.drawString(String.valueOf(verifyCode.charAt(i)), i*17, 18);
				}
			}
			g.dispose();
			
			
			sos = resp.getOutputStream();  
			ImageIO.write(outImg, "png", sos);  
			/*JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos);  
			encoder.encode(outImg);  */
			sos.flush();
		} catch (Exception e) {
			log.error("{} {} 生成图片验证码失败",e.toString());
		}finally{
			if(sos!=null){
				sos.close();
			}
		}
		
	}
	
		/**
		 * 
		 * @Title: getRandomColor
		 * @Description: 随机取色
		 * @param @return
		 * @return Color
		 * @throws
		 */
	  public static Color getRandomColor() {
	    Random ran = new Random();
	    Color color = new Color(ran.nextInt(256), 
	        ran.nextInt(256), ran.nextInt(256));
	    return color;
	  }
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	
	private synchronized StringBuffer randomVerifyCode() {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0; i<6; i++) {
			sb.append(dictinary[random.nextInt(32)]);
		}
		return sb;
	}
}
