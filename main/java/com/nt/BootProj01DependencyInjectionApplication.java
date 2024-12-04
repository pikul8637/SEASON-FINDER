package com.nt;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	
	
@Bean(name="dt")
LocalDate createDate() {
		System.out.println("BootProj01DependencyInjectionApplication.createDate()");
	return LocalDate.now();
	
}
	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//get Spring bean class object ref(Target)
		SeasonFinder finder =ctx.getBean("sf",SeasonFinder.class);
		String resultMsg=finder.findSeason();
		System.out.println("Output is "+resultMsg);
		 ((ConfigurableApplicationContext) ctx).close();
	}

}
