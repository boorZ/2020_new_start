package common.config;

import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 周林
 * @Description swagger2配置中心
 * @email prometheus@noask-ai.com
 * @date 2020/4/15 15:21
 *  Swagger注解类型:
 *      @Api：修饰整个类，描述Controller的作用
 *      @ApiOperation：描述一个类的一个方法，或者说一个接口
 *      @ApiParam：单个参数描述
 *      @ApiModel：用对象来接收参数
 *      @ApiProperty：用对象接收参数时，描述对象的一个字段
 *      @ApiResponse：HTTP响应其中1个描述
 *      @ApiResponses：HTTP响应整体描述
 *      @ApiIgnore：使用该注解忽略这个API
 *      @ApiError ：发生错误返回的信息
 *      @ApiImplicitParam：描述一个请求参数，可以配置参数的中文含义，还可以给参数设置默认值
 *      @ApiImplicitParams：描述由多个 @ApiImplicitParam 注解的参数组成的请求参数列表
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.mybatisplus.ctrl";

    public static final String VERSION = "1.0.0";


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("单词计数服务")
                // 设置文档的描述
                .description("单词计数服务 API 接口文档")
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(VERSION)
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}
