package org.usfirst.frc.team4322.robot;

import org.usfirst.frc.team4322.input.XboxController;
import org.usfirst.frc.team4322.robot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static XboxController pilot;
    
    public OI()
    {
        pilot = new XboxController(0);
        pilot.x.whenPressed(new DriveBase_PIDDrive(
                () -> {
                    return SmartDashboard.getNumber("Vision Center X: ",0.5) -.5;
                    }
                ));
        pilot.y.whenPressed(new Command_Interrupt());
        pilot.a.whenPressed(new Shooter_Spin());
        pilot.b.whenPressed(new Shooter_Spin_Slow());
        pilot.rt.whenPressed(new Shooter_Stop());
    }
}

