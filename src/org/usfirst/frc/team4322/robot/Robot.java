
package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4322.dashboard.*;
import org.usfirst.frc.team4322.logging.RobotLogger;
import org.usfirst.frc.team4322.configuration.*;
import org.usfirst.frc.team4322.robot.commands.*;
import org.usfirst.frc.team4322.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    public static OI oi;
    public static DriveBase driveBase;
   
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        //Start Logger
        RobotLogger.getInstance().update(false);
        //Start Subsystems (Mind Dependencies!)
        driveBase = new DriveBase();
       
        //Start OI
        oi = new OI();
        //Link Classes 
        MapSynchronizer.getInstance().link(RobotMap.class);
        MapSynchronizer.getInstance().link(DriveBase_PIDDrive.class);
        //Load Persistent Values
        MapSynchronizer.getInstance().loadPersistentValues();
        
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit()
    {
        //Write Persistence File
        RobotPersistenceFileWriter.getInstance().write();
    }

    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    public void autonomousInit()
    {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
