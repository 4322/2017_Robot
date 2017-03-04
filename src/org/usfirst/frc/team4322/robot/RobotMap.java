package org.usfirst.frc.team4322.robot;

import org.usfirst.frc.team4322.dashboard.DashboardInputField;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // *******************************
    // ** PDP MAPPINGS **
    // *******************************
    public static final int PDP_DRIVEBASE_LEFT_MASTER = 0;
    public static final int PDP_DRIVEBASE_RIGHT_SLAVE = 1;
    public static final int PDP_DRIVEBASE_LEFT_SLAVE = 2;
    public static final int PDP_DRIVEBASE_RIGHT_MASTER = 3;
    public static final int PDP_JETSON = 4;
    public static final int PDP_CLIMBER = 9;
    public static final int PDP_COLLECTOR = 13;
    public static final int PDP_SHOOTER_SLAVE = 14;
    public static final int PDP_SHOOTER_MASTER = 15;
    // *******************************
    // ** MOTOR CONTROLLER MAPPINGS **
    // *******************************
    public static final int DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR = 10;
    public static final int DRIVEBASE_MOTORCONTROLLER_LEFT_SLAVE_ADDR = 11;
    public static final int DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR = 12;
    public static final int DRIVEBASE_MOTORCONTROLLER_RIGHT_SLAVE_ADDR = 13;
    public static final int SHOOTER_MOTORCONTROLLER_MASTER_ADDR = 20;
    public static final int SHOOTER_MOTORCONTROLLER_SLAVE_ADDR = 21;
    public static final int INDEXER_MOTORCONTROLLER_ADDR = 30;
    public static final int COLLECTOR_MOTORCONTROLLER_ADDR = 40;
    public static final int HOPPER_FLOPPER_RELAY_PORT = 0;
    public static final int GEAR_GRABBER_SPARK_PORT = 1;
    public static final int CLIMPER_MOTORCONTROLLER_PORT = 0;


    // ************************
    // ** SHOOTER MAP VALUES **
    // ************************
    @DashboardInputField(field="Shooter Target RPM (Double): ")
    public static double SHOOTER_RPM_DOUBLE = 2400;
    @DashboardInputField(field="Shooter Target RPM (Single): ")
    public static double SHOOTER_RPM_SINGLE = 2400;
    @DashboardInputField(field="Shooter P: ")
    public static double SHOOTER_P = 0.4;
    @DashboardInputField(field="Shooter I: ")
    public static double SHOOTER_I = 0.0005;
    @DashboardInputField(field="Shooter D: ")
    public static double SHOOTER_D = 35.5;
    @DashboardInputField(field="Shooter F: ")
    public static double SHOOTER_F = 0.04;
    @DashboardInputField(field="Shooter IZ: ")
    public static int SHOOTER_IZ = 65;
    @DashboardInputField(field="Shooter R: ")
    public static double SHOOTER_R = 0.00;
    
    // *********************************
    // ** DRIVEBASE AIMING MAP VALUES **
    // *********************************
    @DashboardInputField(field="Drivebase Aim P: ")
    public static double DRIVEBASE_AIM_P = -1.3;
    @DashboardInputField(field="Drivebase Aim I: ")
    public static double DRIVEBASE_AIM_I = -.120;
    @DashboardInputField(field="Drivebase Aim IZone: ")
    public static double DRIVEBASE_AIM_IZONE = .135;
    @DashboardInputField(field="Drivebase Aim D: ")
    public static double DRIVEBASE_AIM_D = -1.30;
    // *********************************
    // ** DRIVEBASE DRIVING MAP VALUES **
    // *********************************
    @DashboardInputField(field="Drivebase Aim P: ")
    public static double DRIVEBASE_DRIVE_P = -1.3;
    @DashboardInputField(field="Drivebase Aim I: ")
    public static double DRIVEBASE_DRIVE_I = -.120;
    @DashboardInputField(field="Drivebase Aim IZone: ")
    public static double DRIVEBASE_DRIVE_IZONE = .135;
    @DashboardInputField(field="Drivebase Aim D: ")
    public static double DRIVEBASE_DRIVE_D = -1.30;
    // ************************
    // ** INDEXER MAP VALUES **
    // ************************
    @DashboardInputField(field="Indexer Target RPM: ")
    public static double INDEXER_RPM = 360;
    @DashboardInputField(field="Indexer P: ")
    public static double INDEXER_P = 0.20;
    @DashboardInputField(field="Indexer I: ")
    public static double INDEXER_I = 0.05;
    @DashboardInputField(field="Indexer D: ")
    public static double INDEXER_D = 4.50;
    @DashboardInputField(field="Indexer F: ")
    public static double INDEXER_F = 0.1;
    @DashboardInputField(field="Indexer IZ: ")
    public static int INDEXER_IZ = 100;
    @DashboardInputField(field="Indexer R: ")
    public static double INDEXER_R = 0.00;

}
