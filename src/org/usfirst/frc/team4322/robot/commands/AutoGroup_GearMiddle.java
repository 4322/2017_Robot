package org.usfirst.frc.team4322.robot.commands;

        import edu.wpi.first.wpilibj.command.CommandGroup;
        import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
        import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_GearMiddle extends CommandGroup
{
    public AutoGroup_GearMiddle()
    {
        addSequential(new DriveBase_DriveDistance(54,false));
        addParallel(new GearGrabber_EjectGear());
        addParallel(new GearPivot_Lower());
        addSequential(new DriveBase_StupidDriveDistance(30,true));
        addSequential(new Group_RaisePivot());    }
}
