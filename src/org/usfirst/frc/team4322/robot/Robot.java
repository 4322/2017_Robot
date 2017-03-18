
package org.usfirst.frc.team4322.robot;

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
    // Collector Subsystem Class
    public static Collector collector;
    // HopperFlopper Subsystem Class
    public static HopperFlopper hopperFlopper;
    // Conveyor Subsystem Class
    public static Conveyor conveyor;
    // PDP Instance
    public static PowerDistributionPanel pdp;
    //Autonomous
    public static Command autonomousCommand;
    public static SendableChooser autoChooser;
   
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
        collector = new Collector();
        hopperFlopper = new HopperFlopper();
        conveyor = new Conveyor();
        pdp = new PowerDistributionPanel(0);
        //Start OI
        oi = new OI();

        autoChooser = null;


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
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Do Nothing: ", new AutoGroup_DoNothing());
        autoChooser.addObject("Reach Baseline: ", new AutoGroup_ReachBaseline());
        autoChooser.addObject("Gear Middle: (HIGHLY EXPERIMENTAL COLLISION SENSING)", new AutoGroup_GearMiddle());
        autoChooser.addObject("Gear Retrieval: ", new AutoGroup_GearRetrieval());
        autoChooser.addObject("Gear Boiler: ", new AutoGroup_GearBoiler());
        autoChooser.addObject("Hopper + Shoot: ", new AutoGroup_Hopper());
        autoChooser.addObject("Shoot and Drive", new AutoGroup_ShootNotStupid());
//        autoChooser.addObject("Reach Baseline (Stupid)",new AutoGroup_ThisIsStupid());
//        autoChooser.addObject("Shoot and Drive (Stupid)", new AutoGroup_ShootStupid());
        SmartDashboard.putData("AUTO MODES: ", autoChooser);
        //Link Classes for the @DashboardInputField magic
        MapSynchronizer.getInstance().link(RobotMap.class);
        MapSynchronizer.getInstance().link(DriveBase_VisionTurn.class);
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
        Scheduler.getInstance().run();
        Robot.driveBase.resetEncoder();


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
        autonomousCommand = ((Command)autoChooser.getSelected());
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Drivebase Encoder Value",Robot.driveBase.getDist());
    }

    public void teleopInit()
    {
        new Group_StopIndex().start();
        new Shooter_Stop().start();
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
