import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {

    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            
            Trigger trigger = newTrigger().
                    withIdentity("trigger1", "group1").startNow()
                    .withSchedule(simpleSchedule().withIntervalInSeconds(1).withRepeatCount(0))
                    .build();
            
            JobDetail job = newJob(HelloQuartz.class).withIdentity("job1", "group1")
                    .usingJobData("name", "Tom").build();
            
            scheduler.scheduleJob(job, trigger);
            
            scheduler.start();
            
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
