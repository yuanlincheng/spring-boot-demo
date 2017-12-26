package task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/26 14:27
 * description: xxx
 * own: Aratek
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
        log.info("The time is now {}",dataFormat.format(new Date()));
    }
}
