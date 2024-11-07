package hoonjin.com.study.spring.btcores.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class ServerMain {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        String contextPath = "/";

        String warPath = new File("spring/spring-btcores/spring-btcores-server/build/libs/spring-btcores-server-0.0.1-SNAPSHOT-plain.war").getAbsolutePath();
        tomcat.addWebapp(contextPath, warPath);

        tomcat.start();
    }
}
