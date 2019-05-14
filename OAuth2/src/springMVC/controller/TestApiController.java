package springMVC.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springMVC.util.WelEntity;
import springMVC.util.dateUtil;

 

@RestController("testApiController")
@RequestMapping("/api")
public class TestApiController {
	
	
	@RequestMapping("/test")
	public WelEntity test(@RequestParam String reqType){
		String uuid = UUID.randomUUID().toString();
		String welMsg = "welcome ³ÌÐòÔ³";
		if(reqType != null && "1000".equals(reqType)){
			welMsg = "welcome ³ÌÐòæÂ";
		}
		String dateTime = dateUtil.format(new Date(), dateUtil.SimpleDatePattern);
		WelEntity welEntity = new WelEntity();
		welEntity.setUuid(uuid);
		welEntity.setDateTime(dateTime);
		welEntity.setWelMsg(welMsg);
		return welEntity;
	}
	
	@RequestMapping("/map")
	public WelEntity testMap(@RequestParam Map map){
		String uuid = UUID.randomUUID().toString();
		System.out.println("map:"+map.values());
		String reqMsg = (String) map.get("reqMsg");
		System.out.println("******reqMsg******"+reqMsg);
		String welMsg = "welcome ³ÌÐòÔ³" + "----" + reqMsg;
		String reqType = (String) map.get("reqType");
		if(reqType != null && "1000".equals(reqType)){
			welMsg = "welcome ³ÌÐòæÂ";
		}
		String dateTime = dateUtil.format(new Date(), dateUtil.SimpleDatePattern);
		WelEntity welEntity = new WelEntity();
		welEntity.setUuid(uuid);
		welEntity.setDateTime(dateTime);
		welEntity.setWelMsg(welMsg);
		return welEntity;
	}
	
	@RequestMapping("/ret")
	public String testRet(){
		String ret = "this is api";
		return ret;
	}
} 