
package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.dashboard.*;
import org.usfirst.frc.team4322.logging.RobotLogger;
import org.usfirst.frc.team4322.robot.commands.*;
import org.usfirst.frc.team4322.robot.subsystems.*;

import java.io.IOException;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    // Controls Class
    public static OI oi;
    // Drivebase Subsystem Class
    public static DriveBase driveBase;
    // Shooter Subsystem Class
    public static Shooter shooter;
    // Indexer Subsystem Class
    public static Indexer indexer;
    // Climber Subsystem Class
    public static Climber climber;
    // Vision Subsystem Class
    public static Vision vision;
    // GearGrabber Subsystem Class
    public static GearGrabber gearGrabber;
    // Collector Subsystem Class
    public static Collector collector;
   
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
        shooter = new Shooter();
        indexer = new Indexer();
        climber = new Climber();
        vision = new Vision();
        gearGrabber = new GearGrabber();
        collector = new Collector();
        
        //Start OI
        oi = new OI();

        try
        {
            Manifest mf = new JarFile(Robot.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getManifest();
            SmartDashboard.putString("Build Hash:",mf.getMainAttributes().getValue("Build-Hash"));
            SmartDashboard.putString("Build Time:",mf.getMainAttributes().getValue("Build-Time"));
        }
        catch (IOException ex)
        {

        }

        //Link Classes for the Robot Map @DashboardInputField magic 
        MapSynchronizer.getInstance().link(RobotMap.class);
        MapSynchronizer.getInstance().link(DriveBase_PIDDrive.class);        
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit()
    {
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
        SmartDashboard.putNumber("Speed: ",Robot.driveBase.getSpeed());
        SmartDashboard.putNumber("Indexer Position: ", Robot.indexer.get());
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
