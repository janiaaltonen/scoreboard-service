package launch;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * Launch adapted from Heroku devcenter's example
 * 
 * https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat
 * https://github.com/heroku/devcenter-embedded-tomcat
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String webappDirPath = new File("src/main/webapp/").getAbsolutePath();

        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv().getOrDefault("PORT", "8080");
        tomcat.setPort(Integer.parseInt(webPort));

        tomcat.getConnector();

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", webappDirPath);

        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(
                new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        ctx.setRequestCharacterEncoding("utf-8");
        ctx.setResponseCharacterEncoding("utf-8");

        tomcat.start();
        tomcat.getServer().await();
    }
}