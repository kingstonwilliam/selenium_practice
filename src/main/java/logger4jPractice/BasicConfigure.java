package logger4jPractice;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicConfigure {
    static Logger logger = Logger.getLogger(BasicConfigure.class);

   public static void main(String[] args) {
              BasicConfigurator.configure();
              logger.debug("Debug message");
              logger.info("Info message");
              logger.warn("Warn message");
              logger.error("error");
              logger.fatal("fatal");
              
              //log4j.rootLogger=INFO,file,stdout
}
}
