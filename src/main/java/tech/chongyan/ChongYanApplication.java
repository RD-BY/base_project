package tech.chongyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author maj
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ChongYanApplication
    {
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ChongYanApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " \n" +
                " .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. |\n" +
                "| |     ______   | || |  ____  ____  | |\n" +
                "| |   .' ___  |  | || | |_  _||_  _| | |\n" +
                "| |  / .'   \\_|  | || |   \\ \\  / /   | |\n" +
                "| |  | |         | || |    \\ \\/ /    | |\n" +
                "| |  \\ `.___.'\\  | || |    _|  |_    | |\n" +
                "| |   `._____.'  | || |   |______|   | |\n" +
                "| |              | || |              | |\n" +
                "| '--------------' || '--------------' |\n" +
                " '----------------'  '----------------' ");
    }
}
