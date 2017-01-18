package org.usfirst.frc.team4322.robot;

import org.usfirst.frc.team4322.input.XboxController;
import org.usfirst.frc.team4322.robot.commands.*;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static XboxController pilot;
    
    public OI()
    {
        pilot.x.whenPressed(new DriveBase_PIDDrive(RobotMap.DRIVEBASE_AIM_P,RobotMap.DRIVEBASE_AIM_I,RobotMap.DRIVEBASE_AIM_P,() -> {return SmartDashboard.getNumber("Vision Center X:",0.0);}));
        pilot.x.whenReleased(new Command_Interrupt());
    }
}

