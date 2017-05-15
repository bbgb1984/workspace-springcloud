package com.bingo.datasource;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
/**
 * 切换数据源Advice
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Aspect
@Order(-10)//保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
   
	@Pointcut("execution(* com.qbao.service.*.*(..))")  
	public void pointCut(){};
		
    @Before(value = "pointCut()")
    public void changeDataSource(JoinPoint point) throws Throwable {
    	Object target = point.getTarget();
		String method = point.getSignature().getName();
		Class<?>[] classz = target.getClass().getInterfaces();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
			.getMethod().getParameterTypes();
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			System.out.println(m.getName());
			if (m != null && m.getName().toLowerCase().startsWith("update")) {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				 DynamicDataSourceContextHolder.setDataSourceType(DynamicDataSourceContextHolder.DATA_SOURCE_WRITE);
			}else{
				System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
				DynamicDataSourceContextHolder.setDataSourceType(DynamicDataSourceContextHolder.DATA_SOURCE_READ);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
   
    @After(value = "pointCut()")
    public void restoreDataSource(JoinPoint point) {
       //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
   
}