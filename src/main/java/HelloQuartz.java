import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloQuartz implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        // TODO Auto-generated method stub
        JobDetail detail = context.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        
        System.out.println("my job name is " + name + " at " + new Date());
    }

    
}
