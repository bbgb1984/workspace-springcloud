package com.qbao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qbao.entity.User;
import com.qbao.service.IUserService;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    
    @Autowired
	@Qualifier("userService")
	private IUserService useService;


    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "okFallback")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() +":"+instance.getPort()+ ", result:" + r);
        return r;
    }
    
    
    @RequestMapping(value = "/cacheTest" ,method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "okFallback")
    public String cacheTest() {
    	User u=useService.findByName("AAA");
    	System.out.println(u.getName());
    	return u.getName();
    }

    public Integer okFallback(){
    	System.out.println("aaaaaaaaaaaaaa");
    	return -9999;
    }
}