package shop.retail.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * @author Sangram
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerTest {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/shop"), regex("/shop/find"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Retail Manager")
				.description("A Retail Manager who wanting to keep track of their shops")
				.termsOfServiceUrl("http://")
				.contact("sangram.konde@gmail.com").license("SK License")
				.licenseUrl("sangram.konde@gmail.com").version("1.0").build();
	}
}
