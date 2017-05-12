package com.qbao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qbao.entity.User2;
import com.qbao.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ComputeServiceApplication.class)
public class ApplicationTests {

	@Autowired
	@Qualifier("userService")
	private IUserService useService;

	@Test
	@Rollback
	public void findByName() throws Exception {
//		useService.insert("AAA", 20);
//		User u = useService.findByName("AAA");
//		System.out.println(u.getName());
		
		List<User2> userLst=useService.findAll();
		System.out.println("userLst===="+userLst.get(0).getName2());
	}
}