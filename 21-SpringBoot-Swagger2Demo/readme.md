# SpringBoot + Swagger2

## 依赖
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
```
        
## Swagger2配置
    @Configuration
    @EnableSwagger2
    public class Swagger2Config {
    
       @Bean
       public Docket createRestApi() {
          return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("com.xyz.swagger2demo")) //需要配置API的包路径
                  .paths(PathSelectors.any())
                  .build();
       }
    
       private ApiInfo apiInfo() {
          Contact contact = new Contact("程序猿DD","", "");
    
          return new ApiInfoBuilder()
                  .title("Spring Boot中使用Swagger2构建RESTful APIs")
                  .description("更多Spring Boot相关文章请关注")
                  .termsOfServiceUrl("https://github.com/buyimoutianxia/XyzSpringBootDemo")
                  .contact(contact)
                  .version("1.0")
                  .build();
       }
    
    }

通过@EnableSwagger2开启Swagger2配置,然后配置1个Docket Bean,在Bean中配置扫描接口的位置
启动项目，输入http://localhost:8080/swagger-ui.html，能够看到如下页面，说明配置成功:

```!
图片如何放进来？
```
##创建接口
```$xslt
@RestController
@Api(tags = "用户相关接口" )
public class Swagger2Controller {

    /**
     * 增加用户
     */
    @GetMapping("/add")
    @ApiOperation(value = "增加用户接口", notes = "根据URL中内容增加用户")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name="id" ,value="id"),
                    @ApiImplicitParam(name="name", value = "用户名" , defaultValue = "xyz"),
                    @ApiImplicitParam(name="address", value = "地址", defaultValue = "address_xyz")
            }
    )
    public String addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("address") String address) {
        return "id:" + id + ",name:" + name + ",address:" + address;
    }

    /**
     * 根据ID更新用户
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "更新用户", notes = "根据用户ID更新用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID",  required = true)
    public String updateUser(@PathVariable("id") int id) {
        return "id:" + id;
    }

    /**
     * 查询用户
     */
    @ApiOperation(value = "获取用户信息", notes = "获取所有用户信息")
    @GetMapping("/list")
    public String listUser() {
        return "userList";
    }

}

```

* @Api注解可以用来标记当前Controller的功能
* @ApiOperation注解用来标记一个方法的作用
* @ApiImplicitParam注解用来描述一个参数，可以配置参数的中文含义，也可以给参数设置默认值，这样在接口测试的时候可以避免手动输入
* 如果有多个参数，则需要使用多个@ApiImplicitParam注解来描述，多个@ApiImplicitParam注解需要放在一个@ApiImplicitParams注解中

## 参考文献
* [Spring Boot中使用Swagger2构建强大的RESTful API文档](http://blog.didispace.com/springbootswagger2/)
* [SpringBoot整合Swagger2，再也不用维护接口文档了](http://springboot.javaboy.org/2019/0416/springboot-swagger)