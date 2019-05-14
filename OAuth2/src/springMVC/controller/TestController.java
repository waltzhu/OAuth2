package springMVC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springMVC.util.ParamInfo;
import springMVC.util.WelEntity;
import springMVC.util.dateUtil;

 

@RestController("testController")
@RequestMapping("/test")
public class TestController {
	/*
	 * @Autowired ParamInfoService paramInfoService;
	 * 
	 * @Autowired ParamInfoCache paramInfoCache;
	 */
	
	@RequestMapping("/welCome")
	public WelEntity welCome(@RequestParam String reqType){
		String uuid = UUID.randomUUID().toString();
		String welMsg = "welcome coder";
		if(reqType != null && "1000".equals(reqType)){
			welMsg = "welcome coder";
		}
		String dateTime = dateUtil.format(new Date(), dateUtil.SimpleDatePattern);
		WelEntity welEntity = new WelEntity();
		welEntity.setUuid(uuid);
		welEntity.setDateTime(dateTime);
		welEntity.setWelMsg(welMsg);
		return welEntity;
	}
	
	@RequestMapping("/testparam")
	public ParamInfo testParam(@RequestParam String reqType){
		/*
		 * if(reqType ==null || "".equals(reqType))return null; return
		 * paramInfoService.getParamInfo(reqType).get(0);
		 */
		return new ParamInfo();
	}
	
	@RequestMapping("/testcache")
	public List<ParamInfo> testCache(@RequestParam String reqType){
		/*
		 * if(reqType ==null || "".equals(reqType))return null; return
		 * paramInfoCache.getParamInfoCache(reqType);
		 */
		List a=new ArrayList();
		a.add(new ParamInfo());
		//return paramInfoCache.getAllParamInfoCache();
		return a;
	}
	
	@RequestMapping("/updatecache")
	public List<ParamInfo> updateCache(@RequestParam String reqType){
		/*
		 * if(reqType ==null || "".equals(reqType))return null; return
		 * paramInfoCache.updateParamInfoCache(reqType);
		 */
		List a=new ArrayList();
		a.add(new ParamInfo());
		//return paramInfoCache.getAllParamInfoCache();
		return a;
	}
	
	@RequestMapping("/testupdatecache")
	public List<ParamInfo> updateTestCache(@RequestParam String reqType){
		/*
		 * if(reqType ==null || "".equals(reqType))return null; return
		 * paramInfoCache.updateTestParamInfoCache(reqType);
		 */
		List a=new ArrayList();
		a.add(new ParamInfo());
		//return paramInfoCache.getAllParamInfoCache();
		return a;
	}
	
	@RequestMapping("/testallcache")
	public List<ParamInfo> testAllCache(){
		List a=new ArrayList();
		a.add(new ParamInfo());
		//return paramInfoCache.getAllParamInfoCache();
		return a;
	}
	
	@RequestMapping("/imgtoken")
	public String imgtoken(HttpServletRequest request){
		String imgtoken = "1234";
		RandomValueStringGenerator generator = new RandomValueStringGenerator(4);
		imgtoken = generator.generate();
		if(!StringUtils.isEmpty(request.getParameter("imgtoken"))){
			imgtoken = (String) request.getParameter("imgtoken");
		}
		System.out.println(imgtoken);
		request.getSession().setAttribute("imgtoken", imgtoken);
		return imgtoken;
	}
}
