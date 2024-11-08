package hoonjin.com.study.spring.btcores.server.container;

import hoonjin.com.study.spring.btcores.server.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV3SpringMvc implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("AppInitV3SpringMvc.onStartup");

        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(HelloConfig.class);

        // spring mvc dispatcher servlet 생성, 스프링 컨테이너 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        servletContext.addServlet("dispatcherV3", dispatcherServlet)
            .addMapping("/*");
    }
}
