
###spring cloud demo ,实例代码详解请参考 http://blog.didispace.com/springcloud1/ <br>

- [server-cluster-1] : 服务注册中心 ，工程可以打成jar包，启动多个实例形成一个注册服务集群，工程里配置了3个实例，启动方式如下：<br>
java -jar server-cluster-1.jar --spring.profiles.active=peer1<br>
java -jar server-cluster-1.jar --spring.profiles.active=peer2<br>
java -jar server-cluster-1.jar --spring.profiles.active=peer3<br>
- [service-A] :服务注册 注册多个服务实例，可以参考server-cluster-1<br>
- [eureka-feign]: 服务发现,使用的是feign,也可以使用ribbon,feign,功能更强大，默认支持服务调用的负载均衡，以及熔断和降级<br>
- [gateway]: 服务网关 <br>