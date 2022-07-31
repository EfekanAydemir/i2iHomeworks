import org.apache.logging.log4j.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/* This program runs only for 3 levels --> fatal , warn ,error
    for example, "trace" level doesn't work with any other levels
    you have to choose spesific level
 */



public class test {

    private static Logger logger = LogManager.getLogger(test.class.getName());
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
    private static SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
    private static SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
    private static SimpleDateFormat secondFormat = new SimpleDateFormat("ss");


    public static void main(String[] args) throws InterruptedException {
        Date durableDate = new Date();

        String durableHour = hourFormat.format(durableDate);
        String durableMinute = minuteFormat.format(durableDate);
        String durableSecond = secondFormat.format(durableDate);


        while (true) {
            Date changingDate = new Date();
            String currentHour = hourFormat.format(changingDate);
            String currentMinute = minuteFormat.format(changingDate);
            String currentSecond = secondFormat.format(changingDate);

            String loggerLevel = logger.getLevel().toString().toLowerCase(Locale.ROOT);
            switch (loggerLevel) {
                case "fatal":
                    logger.fatal(durableHour + ":" + durableMinute + ":" + currentSecond);
                    Thread.sleep(1000);
                    break;
                case "warn":
                    logger.warn(currentHour + ":" + durableMinute + ":" + durableSecond);
                    Thread.sleep(3600000);
                    break;
                case "error":
                    logger.error(durableHour + ":" + currentMinute + ":" + durableSecond);
                    Thread.sleep(60000);
                    break;
            }
        }
    }
}