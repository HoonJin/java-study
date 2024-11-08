package hoonjin.com.study.spring.btcores.server.container;

import hoonjin.com.study.spring.btcores.server.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit {
    @Override
    public void onStartUp(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartUp");

        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(HelloConfig.class);

        // spring mvc dispatcher servlet 생성, 스프링 컨테이너 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic dispatcherV2 = servletContext.addServlet("dispatcherV2", dispatcherServlet);
        dispatcherV2.addMapping("/spring/*");
    }
}
