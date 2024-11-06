package hoonjin.com.study.spring.btcores.server.container;

import jakarta.servlet.ServletContext;

public interface AppInit {

    void onStartUp(ServletContext servletContext);
}
