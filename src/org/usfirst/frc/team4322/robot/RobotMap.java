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
    @DashboardInputField(field="Shooter RPM: ")
    public static double SHOOTER_RPM = 2400;
    @DashboardInputField(field="Shooter RPM (Slow): ")
    public static double SHOOTER_RPM_SLOW = 2400;
    @DashboardInputField(field="Drivebase Aim P: ")
    public static double DRIVEBASE_AIM_P = -1.3;
    @DashboardInputField(field="Drivebase Aim I: ")
    public static double DRIVEBASE_AIM_I = -.120;
    @DashboardInputField(field="Drivebase Aim IZone: ")
    public static double DRIVEBASE_AIM_IZONE = .135;
    @DashboardInputField(field="Drivebase Aim D: ")
    public static double DRIVEBASE_AIM_D = -1.30;
}
