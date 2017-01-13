package org.usfirst.frc.team4488.robot;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;

public class Drive {
	
	RobotDrive driveBase;
	CANTalon FR;
	CANTalon BR;
	CANTalon FL;
	CANTalon BL;
	AHRS navx;
	
	public Drive(){
		FR = new CANTalon(RobotMap.FrontRightMotor);
		BR = new CANTalon(RobotMap.BackRightMotor);
		FL = new CANTalon(RobotMap.FrontLeftMotor);
		BL = new CANTalon(RobotMap.BackLeftMotor);
        navx = new AHRS(SPI.Port.kMXP);
        driveBase = new RobotDrive(FL, BL, FR, BR);
	}
	
	public void teleopDrive(Joystick xbox){
		driveBase.mecanumDrive_Cartesian(xbox.getRawAxis(1), xbox.getRawAxis(2), xbox.getRawAxis(4), navx.getYaw());
	}
	
	
	//Would this be a way to do autonomous driving?
	public void setMotors(double FRpower, double BRpower, double FLpower, double BLpower){
		FR.set(FRpower);
		BR.set(BRpower);
		FL.set(FLpower);
		BL.set(BLpower);
	}

}