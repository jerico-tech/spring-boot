1. @RequestParam和@PathVariable注解的区别
@RequestParam和@PathVariable这两者之间区别不大，主要是请求的URL不一样

用@RequestParam请求接口时,URL是:http://www.test.com/user/getUserById?userId=1

用@PathVariable请求接口时,URL是:http://www.test.com/user/getUserById/2

2. 参数的默认值
@RequestParam使用defaultValue属性设置默认值
注意设置必须是string类型的，框架自己会做转换

			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "size", required = false) Integer size,
————————————————
版权声明：本文为CSDN博主「y41992910」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/y41992910/article/details/88314233

3. 参数校验

