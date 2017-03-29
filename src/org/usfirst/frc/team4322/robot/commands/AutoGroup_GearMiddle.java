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
        addSequential(new Group_HomePivot());

        addSequential(new DriveBase_DriveDistance(25,false,false,false)); //Drive up to peg
//        addSequential(new DriveBase_ReallyStupidDrive()); //cancer
        addParallel(new Group_EjectGear()); //Put gear on peg
        addSequential(new Command_Delay(500));
        addSequential(new DriveBase_DriveDistance(-10,false)); //Back up a bit
    }
}
