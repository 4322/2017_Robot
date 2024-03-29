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
    public static XboxController operator;
    
    public OI()
    {
        //DRIVER CONTROLS
        pilot = new XboxController(0);
        operator = new XboxController(1);
        pilot.back.whenPressed(new Command_Interrupt());


        // Left Bumper to run the Collector
        pilot.lb.whileHeld(new Collector_Start());
        // left joystick to start gear vision
        pilot.leftStick.whenPressed(new Vision_RunGear());
        // right joystick to start boiler vision
        pilot.rightStick.whenPressed(new Vision_RunBoiler());
        // start to end vision
        pilot.start.whenPressed(new Vision_Stop());



        //OPERATOR CONTROLS
        // A button for double-barrel RPM
        operator.a.whenPressed(new Shooter_Spin());
        // Right Trigger to stop the Shooter
        operator.rt.whenPressed(new Shooter_Stop());
        // Left Trigger to index and convey
        operator.lt.whileHeld(new Group_StartIndex());
        // Prepare to collect a gear
        operator.x.whileHeld(new Group_GrabGear());
        operator.x.whenReleased(new Group_RaisePivot());
        // X button to eject gear
        operator.y.whenPressed(new Group_EjectGear());
        operator.b.whenPressed(new Group_HomePivot());

    }
}

