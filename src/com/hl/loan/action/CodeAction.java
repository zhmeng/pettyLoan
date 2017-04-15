package com.hl.loan.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionContext;


@Namespace("/mast/code")
@ResultPath(value="/")
public class CodeAction extends BaseAction {
	private String temp;
	private String codes;
	private String bz;
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	public String getTemp() { 
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public static final Integer NUM = 4;
	@Action(value="getCode", results={
			@Result(name="success",location="/index.jsp")
	})
	public void getCode() throws IOException{
		ActionContext context = ActionContext.getContext();  
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();;  
		response.addHeader("pragma", "no-cache");
		response.addHeader("cache-control", "no-cache");
		response.addHeader("expires", "0");

  
		//System.out.println("image");
		char[] rands = getRandom();
		String temp  = new String(rands);
		request.getSession().setAttribute("temp", temp);

		//产生图片缓冲区
		BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
		//得到缓图对象
		Graphics g  = bufferedImage.getGraphics();
		//设置背景色
		g.setColor(Color.lightGray);
		//填充
		g.fillRect(0, 0, 80, 20);
 
		//写字
		g.setColor(Color.blue);
		g.setFont(new Font("宋体",Font.BOLD,22));
		g.drawString(rands[0]+"", 0, 16);
		g.drawString(rands[1]+"", 20, 15);
		g.drawString(rands[2]+"", 40, 14);
		g.drawString(rands[3]+"", 60, 16);
 
		//四根线
		Random r = new Random();
		g.setColor(Color.pink);
		g.drawLine(r.nextInt(80), r.nextInt(20),r.nextInt(80), r.nextInt(20));
		g.drawLine(r.nextInt(80), r.nextInt(20),r.nextInt(80), r.nextInt(20));
		g.drawLine(r.nextInt(80), r.nextInt(20),r.nextInt(80), r.nextInt(20));
		g.drawLine(r.nextInt(80), r.nextInt(20),r.nextInt(80), r.nextInt(20));
		//生成jpeg
		ImageIO.write(bufferedImage, "jpeg", response.getOutputStream());
		this.temp=temp;
		
	}
	@Action(value="judCode", results={
			@Result(name="success",location="/index.jsp")
	})
	public void judCode() throws IOException{
		String code=this.getRequest().getParameter("codes");
		String  temp =  (String) ActionContext.getContext().getSession().get("temp");
		String bz="0";
		if(code!=null && code.trim().length()>0){
			if(code.equalsIgnoreCase(temp)){
				bz="1";
			}else{
				bz="2";//验证码错误
			}
		}else{
			bz="2";//验证码错误
		}
		//this.writeResult(true, bz, this.getResponse());
		returnPopupMessage(true ? bz : "0");
	}
	//产生四个随机数
	public char[] getRandom()
	{
		//源始的内容
		String str = "23456789ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz";
		//存放随机数
		char[] rands = new char[NUM];
		Random  random   = new Random();
		for (int i=0;i<NUM;i++)
		{
			int index = random.nextInt(54);
			rands[i] = str.charAt(index);
		}
		return rands;
	}
}






