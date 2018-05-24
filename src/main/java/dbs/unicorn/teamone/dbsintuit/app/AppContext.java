package dbs.unicorn.teamone.dbsintuit.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppContext implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("css/**").addResourceLocations("classpath:static/css/");
		registry.addResourceHandler("js/**").addResourceLocations("classpath:static/js/");
		
		registry.addResourceHandler("vendor/bootstrap/js/**").addResourceLocations("classpath:static/vendor/bootstrap/js/");
		registry.addResourceHandler("vendor/bootstrap/css/**").addResourceLocations("classpath:static/vendor/bootstrap/css/");
		
		registry.addResourceHandler("vendor/bootstrap-multiselect/js/**").addResourceLocations("classpath:static/vendor/bootstrap-multiselect/js/");
		registry.addResourceHandler("vendor/bootstrap-multiselect/css/**").addResourceLocations("classpath:static/vendor/bootstrap-multiselect/css/");
		
		registry.addResourceHandler("vendor/jquery/**").addResourceLocations("classpath:static/vendor/jquery/");
		registry.addResourceHandler("vendor/jquery-easing/**").addResourceLocations("classpath:static/vendor/jquery-easing/");
		
		registry.addResourceHandler("vendor/font-awesome/**").addResourceLocations("classpath:static/vendor/font-awesome/");
		registry.addResourceHandler("vendor/jquery-easing/**").addResourceLocations("classpath:static/vendor/jquery-easing/");
		
		registry.addResourceHandler("vendor/chart.js/**").addResourceLocations("classpath:static/vendor/chart.js/");
		registry.addResourceHandler("vendor/datatables/**").addResourceLocations("classpath:static/vendor/datatables/");
		
		
		registry.addResourceHandler("pug/**").addResourceLocations("classpath:static/pug/");
		registry.addResourceHandler("scss/**").addResourceLocations("classpath:static/scss/");
		registry.addResourceHandler("vendor/**").addResourceLocations("classpath:static/venor/");

	}

}
