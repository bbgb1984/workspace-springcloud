package com.bingo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComputeClientHystrix implements ComputeClient {
	   public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b){
		// TODO Auto-generated method stub
		   System.out.println("fallback");
		return -9999;
	}
}