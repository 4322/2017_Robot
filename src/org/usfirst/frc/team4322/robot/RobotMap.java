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
    public static final int GEAR_GRABBER_SPARK_PORT = 3;
    public static final int GEAR_PIVOT_SPARK_PORT = 1;
    public static final int CLIMPER_MOTORCONTROLLER_PORT = 0;
	public static final int CONVEYOR_MOTORCONTROLLER_PORT = 2;

    // ******************
    // ** DIO MAPPINGS **
    // ******************
    public static final int AUTO_SELECTOR_DIO_PORT_0 = 0;
    public static final int AUTO_SELECTOR_DIO_PORT_1 = 1;
    public static final int AUTO_SELECTOR_DIO_PORT_2 = 2;
    public static final int AUTO_SELECTOR_DIO_PORT_3 = 3;
    public static final int GEAR_PIVOT_LIMIT_DIO_PORT = 4;

    // *********************
    // ** ANALOG MAPPINGS **
    // *********************
    public static final int GEAR_PIVOT_ENCODER_ANALOG_PORT = 0;


    // ************************
    // ** SHOOTER MAP VALUES **
    // ************************
    @DashboardInputField(field="Shooter Target RPM: ")
    public static double SHOOTER_RPM = 2700; //at 69" from boiler lol
//    @DashboardInputField(field="Shooter P: ")
    public static double SHOOTER_P = 0.4;
//    @DashboardInputField(field="Shooter I: ")
    public static double SHOOTER_I = 0.0005;
//    @DashboardInputField(field="Shooter D: ")
    public static double SHOOTER_D = 35.5;
//    @DashboardInputField(field="Shooter F: ")
    public static double SHOOTER_F = 0.04;
//    @DashboardInputField(field="Shooter IZ: ")
    public static int SHOOTER_IZ = 65;
//    @DashboardInputField(field="Shooter R: ")
    public static double SHOOTER_R = 0.00;

    // ***********************************
    // ** DRIVEBASE TALON CONFIG VALUES **
    // ***********************************
    public static final int DRIVEBASE_TALON_RAMP_RATE = 48;
    public static final int DRIVEBASE_ENCODER_COUNTS_PER_REV = 256;

    // ** DRIVEBASE AIMING MAP VALUES **
    // *********************************
    @DashboardInputField(field="Drivebase Aim P: ")
    public static double DRIVEBASE_AIM_P = .600;
    @DashboardInputField(field="Drivebase Aim I: ")
    public static double DRIVEBASE_AIM_I = 0.0125;
    @DashboardInputField(field="Drivebase Aim IZone: ")
    public static double DRIVEBASE_AIM_IZONE = 10;
    @DashboardInputField(field="Drivebase Aim D: ")
    public static double DRIVEBASE_AIM_D = 0.02275;
    // *********************************
    // ** DRIVEBASE DRIVING MAP VALUES **
    // *********************************
    @DashboardInputField(field="Drivebase Drive P: ")
    public static double DRIVEBASE_DRIVE_P = .0035;
    @DashboardInputField(field="Drivebase Drive I: ")
    public static double DRIVEBASE_DRIVE_I = 0;
    @DashboardInputField(field="Drivebase Drive IZone: ")
    public static double DRIVEBASE_DRIVE_IZONE = 0;
    @DashboardInputField(field="Drivebase Drive D: ")
    public static double DRIVEBASE_DRIVE_D = 0.003;
    @DashboardInputField(field="Drivebase Error Tolerance: ")
    public static double AUTON_DRIVE_TOLERANCE = .750;
    // *********************************
    // ** DRIVEBASE NAVX MAP VALUES **
    // *********************************
    @DashboardInputField(field="Drivebase Navx P: ")
    public static double DRIVEBASE_NAVX_P = .00005;
    @DashboardInputField(field="Drivebase Navx I: ")
    public static double DRIVEBASE_NAVX_I = 0;
    @DashboardInputField(field="Drivebase Navx IZone: ")
    public static double DRIVEBASE_NAVX_IZONE = 0;
    @DashboardInputField(field="Drivebase Navx D: ")
    public static double DRIVEBASE_NAVX_D = 0;
    @DashboardInputField(field="Drivebase Navx Tolerance: ")
    public static double AUTON_NAVX_TOLERANCE = .750;
    @DashboardInputField(field="Smooth Turn Gain: ")
    public static double TURN_GAIN=5.6;
    // ************************
    // ** INDEXER MAP VALUES **
    // ************************
//    @DashboardInputField(field="Indexer Target RPM: ")
    public static double INDEXER_RPM = 360;
//    @DashboardInputField(field="Indexer P: ")
    public static double INDEXER_P = 0.20;
//    @DashboardInputField(field="Indexer I: ")
    public static double INDEXER_I = 0.05;
//    @DashboardInputField(field="Indexer D: ")
    public static double INDEXER_D = 4.50;
//    @DashboardInputField(field="Indexer F: ")
    public static double INDEXER_F = 0.1;
//    @DashboardInputField(field="Indexer IZ: ")
    public static int INDEXER_IZ = 100;
//    @DashboardInputField(field="Indexer R: ")
    public static double INDEXER_R = 0.00;


}
