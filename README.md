# spring-boot-basis
springboot使用基础，包括自定义异常，获取变量，logback日志配置，springboot监控actuator的配置
1.	SpringBoot是伴随着spring4.0诞生的，内嵌了一个Web服务器tomcat/jetty的可执行程序的框架，可以直接打成jar包，自带容器，可直接执行
2.	SpringBoot解决了什么问题
a)	配置变简单
b)	使编码变简单
i.	SpringBoot开发一个简单的接口，只需要配置一个web的依赖，在controller中使用注解写一个方法即可
c)	使部署变简单
i.	
d)	使监控变简单
3.	自定义配置
a)	在配置文件中（yml文件）配置变量
i.	在类中使用@Value（&{}）来接收对应的变量值
b)	配置变量的引用：使用${变量名称}，可以直接引用相应的变量
c)	随机值 的配置
i.	${random.int}    可以获取随机值变量
4.	Yml配置文件（ymal）
5.	Spring Boot文件的日志配置（默认常用logback ）
6.	Springboot多环境的配置（使用场景是在项目开发中会出现多个环境，开发，测试，线上环境等）
a)	需要配置多个版本的配置文件 
b)	打包时需要注意命令跳过测试类：mvn clean package -Dmaven.test.skip=true
c)	打包成jar后，该包中含有之前设置得多个配置文件
i.	启动该jar包使用命令：java -jar xxxxxxx.jar –spring.profiles.active=dev
7.	Springboot核心注解
a)	@SpringBootApplication该注解下包含一下注解
i.	@SpringBootConfiguration和@Configuration的功能是一样的，是用来代替xml中的bean，自从有了该配置之后可以不需要在xml中配置bean，该配置可以将bean直接注入到spring IOC中
ii.	@EnableAutoConfiguration：自动加载jar包的默认配置
iii.	@ComponentScan：代替之前配置的<context:component-scan>
b)	@RestController包含以下的注解
i.	@Controller：表示为springMVC的一个controller处理器，也可以说是一个selete容器
ii.	@ResponseBody：将一个controller方法返回的对象转化为json数据直接写入http
c)	@RequestMapping：
i.	指定url映射的路径
d)	一种springboot的异常统一处理方法
i.	@controllerAdvice
1.	自定义一个全局异常处理类
2.	写一个异常处理方法 ，返回值是map<String,Object>
3.	该方法上必须有@ResponseBody，@ExceptionHandler(value = Exception.class)两个注解
ii.	自定义异常 
e)	如何监控springBoot的健康状况 
i.	使用actuator检查和监控springboot的健康
1.	需要添加actuator依赖
2.	在配置文件中配置检测路径和检测信息地址
a)	配置参考博客：https://www.cnblogs.com/jmcui/p/9820579.html
3.	重点：查看当前运行的线程信息
a)	url: http://localhost:8090/actuator/threaddump
b)	返回内容："threads":[
c)	{
d)	"threadName":"DestroyJavaVM", //线程名
e)	"threadId":45,  //线程ID号
f)	"blockedTime":-1,  //阻塞时间，-1代表没有阻塞
g)	"blockedCount":0,  //阻塞的个数
h)	"waitedTime":-1,  //等待时间
i)	"waitedCount":0,  //等待的线程数量
j)	"lockName":null,  //锁名称
k)	"lockOwnerId":-1, //锁得拥有着ID
l)	"lockOwnerName":null, //锁得拥有者名称
m)	"inNative":false, //是否为本地现成，false表示不是
n)	"suspended":false, //是否为过期
o)	"threadState":"RUNNABLE",//线程目前得状态  RUNABLE:运行状态
p)	"stackTrace":[ //堆栈得跟踪信息
q)	],
r)	"lockedMonitors":[  //锁得监控
s)	],
t)	"lockedSynchronizers":[//锁得同步
u)	],
v)	"lockInfo":null  //锁得信息
w)	},
ii.	使用简洁可视化得监控报表spring boot admin,其分为服务端和客户端
1.	Spring Boot Admin 2.0 详解，参考博客：http://blog.itpub.net/69926045/viewspace-2646330/
