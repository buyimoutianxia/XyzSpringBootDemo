## Banner隐藏
隐藏的方式SpringBoot提供了两种，不过其中application.properties方式已经被抛弃掉了，我们下面介绍下修改SpringBootApplication配置的方式。具体代码如下所示：
<pre>
    public static void main(String[] args) {
        //原启动方式
//        SpringApplication.run(BannerdemoApplication.class, args);
        /**
         * 隐藏Banner的启动方式
         */
        SpringApplication springApplication = new SpringApplication(BannerdemoApplication.class);
        //设置Banner的方式为隐藏
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动SpringApplication
        springApplication.run(args);
    }
</pre>

##  Banner修改
在src/main/resources下添加一个名叫banner.txt的文件
