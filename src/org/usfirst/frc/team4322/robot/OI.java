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
        pilot.dPad.whenPressed(new DriveBase_PIDDrive(() -> {
            return SmartDashboard.getNumber("Vision Center X: ", 0.5) - .5;
        }));
        pilot.back.whenPressed(new Command_Interrupt());
        // A button for double-barrel RPM
        pilot.a.whenPressed(new Shooter_Spin());
        // B button for single-barrel RPM
        pilot.b.whenPressed(new Shooter_Spin_Slow());
        // Right Trigger to stop the Shooter
        pilot.rt.whenPressed(new Shooter_Stop());
        // Left Bumper to start the Collector
        pilot.lb.whenPressed(new Collector_Start());
        // Right Bumper to stop the Collector
        pilot.rb.whenPressed(new Collector_Stop());
        // left joystick to start gear vision
        pilot.leftStick.whenPressed(new Vision_RunGear());
        // right joystick to start boiler vision
        pilot.rightStick.whenPressed(new Vision_RunBoiler());
        // start to end vision
        pilot.start.whenPressed(new Vision_Stop());
        pilot.y.whileHeld(new GearGrabber_PrepareForGear());
        pilot.x.whileHeld(new GearGrabber_EjectGear());
    }
}

