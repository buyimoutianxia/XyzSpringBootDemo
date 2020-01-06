## Lombok
@Getter
@Setter可以放到变量上，也可以放到类上，自动生成对应的get和set方法

@ToString放到类上面，自动生成ToString方法

@AllArgsConstructor带参数构造函数
@NoArgsConstructor无参数构造函数

@Data注解相当于@Setter+@Getter+@ToString

@Slf4j
自动创建一个日志对象作为类内全局字段
