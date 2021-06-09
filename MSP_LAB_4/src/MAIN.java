import MBean.Percentage;
import MBean.PointChecker;
import commands.Help;
import commands.History;
import commands.Shoot;
import hitting.Shot;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

public class MAIN {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        ArrayList<Shot> his = new ArrayList<>();
        History history = new History(his);
        Shoot shoot = new Shoot();
        Help help = new Help();

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Maksyao:type=PointChecker");
        ObjectName name1 = new ObjectName("Maksyao:type=Percentage");
        PointChecker pointChecker = new PointChecker(his);
        Percentage percentage = new Percentage(his);
        mbs.registerMBean(pointChecker,name);
        mbs.registerMBean(percentage, name1);




        CommandReader dialog = new CommandReader(history, shoot, help, pointChecker, percentage);

        dialog.start_reading();
    }
}
