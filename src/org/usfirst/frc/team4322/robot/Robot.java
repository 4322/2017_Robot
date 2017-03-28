
package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
    // Climper Subsystem Class
    public static Climper climper;
    // Vision Subsystem Class
    public static Vision vision;
    // GearGrabber Subsystem Class
    public static GearGrabber gearGrabber;
    // GearPivot Subsystem Class
    public static GearPivot gearPivot;
    // Collector Subsystem Class
    public static Collector collector;
    // Conveyor Subsystem Class
    public static Conveyor conveyor;
    // PDP Instance
    public static PowerDistributionPanel pdp;
    //Autonomous
    public static Command autonomousCommand;
    public static AutoChooser autoSwitch;

    public String[] autoNames = {"Do Nothing","Reach Baseline","Shoot + Drive","Gear Middle","Gear Boiler","Gear Retrieval","Hopper + Shoot","Über","Do Nothing","Do Nothing"};
    public Command[] autoCommands;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        //Start Logger
        RobotLogger.getInstance().update(false);
        MapSynchronizer.getInstance().link(RobotLogger.class);
        //Start Subsystems (Mind Dependencies!)
        driveBase = new DriveBase();
        shooter = new Shooter();
        indexer = new Indexer();
        climper = new Climper();
        vision = new Vision();
        gearGrabber = new GearGrabber();
        gearPivot = new GearPivot();
        collector = new Collector();
        conveyor = new Conveyor();
        pdp = new PowerDistributionPanel(0);
        //Start OI
        oi = new OI();
        Command[] tmp = {new AutoGroup_DoNothing(), new AutoGroup_ShootNotStupid(), new AutoGroup_GearMiddle(), new AutoGroup_GearBoiler(), new AutoGroup_GearRetrieval(), new AutoGroup_Hopper(), new AutoGroup_Über(),new AutoGroup_DoNothing(), new AutoGroup_DoNothing()};
        autoCommands = tmp;
        autoSwitch = new AutoChooser();
        RobotLogger.getInstance().log("Test oiuehoewhguierhoigw");

        try
        {
            Manifest mf = new JarFile(Robot.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getManifest();
            RobotLogger.getInstance().info("Starting Build %s constructed at %s.",mf.getMainAttributes().getValue("Build-Hash"),mf.getMainAttributes().getValue("Build-Time"));
            SmartDashboard.putString("Build Hash:",mf.getMainAttributes().getValue("Build-Hash"));
            SmartDashboard.putString("Build Time:",mf.getMainAttributes().getValue("Build-Time"));
        }
        catch (IOException ex)
        {

        }
        SmartDashboard.putNumber("Drive Power: ",0.0);
        //Link Classes for the @DashboardInputField magic
        MapSynchronizer.getInstance().link(RobotMap.class);
        MapSynchronizer.getInstance().link(DriveBase_VisionTurn.class);
        CameraServer.getInstance().startAutomaticCapture();
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
        SmartDashboard.putNumber("Navx Yaw: ",Robot.driveBase.getAngle());
        SmartDashboard.putNumber("Drivebase Encoder Value",Robot.driveBase.getDist());
        Scheduler.getInstance().run();
        Robot.driveBase.resetEncoder();
        Robot.driveBase.resetNavX();
        SmartDashboard.putNumber("Auto Switch: ",autoSwitch.get());
        SmartDashboard.putString("Selected Auto: ",autoNames[autoSwitch.get()]);

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
        autonomousCommand = autoCommands[autoSwitch.get()];
        autonomousCommand.start();
        RobotLogger.getInstance().update(false);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Drivebase Encoder Value",Robot.driveBase.getDist());
        SmartDashboard.putData(Scheduler.getInstance());
        RobotLogger.getInstance().log("Command running: ", autonomousCommand.getName());

    }

    public void teleopInit()
    {
        new Group_StopIndex().start();
        new Shooter_Stop().start();
        RobotLogger.getInstance().update(false);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        SmartDashboard.putNumber("Speed: ",Robot.driveBase.getSpeed());
        SmartDashboard.putNumber("Indexer Position: ", Robot.indexer.get());
        SmartDashboard.putNumber("Drivebase Encoder Value",Robot.driveBase.getDist());
        SmartDashboard.putNumber("Shooter Power Draw Master: ",pdp.getCurrent(RobotMap.PDP_SHOOTER_MASTER));
        SmartDashboard.putNumber("Shooter Power Draw Slave: ",pdp.getCurrent(RobotMap.PDP_SHOOTER_SLAVE));
        SmartDashboard.putNumber("Climper Power Draw: ",pdp.getCurrent(RobotMap.PDP_CLIMBER));
        SmartDashboard.putNumber("Collector Power Draw: ",pdp.getCurrent(RobotMap.PDP_COLLECTOR));
        SmartDashboard.putNumber("Total Power Draw: ",pdp.getTotalCurrent());
        SmartDashboard.putNumber("Door Motor Counts: ",gearPivot.get());
        Scheduler.getInstance().run();
        SmartDashboard.putData("Scheduler: ", Scheduler.getInstance());
        SmartDashboard.putBoolean("Limit Switch Pivot: ",gearPivot.home());

    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
