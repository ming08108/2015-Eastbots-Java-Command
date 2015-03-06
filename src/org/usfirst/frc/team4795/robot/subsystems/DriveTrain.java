package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	private CANJaguar leftMotor, rightMotor; 
	private AnalogInput rangeFinder;
	
	public DriveTrain(){
		super();
		
		leftMotor = new CANJaguar(RobotMap.leftMotor);
		rightMotor = new CANJaguar(RobotMap.rightMotor);
		
		rangeFinder = new AnalogInput(0);
		
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    
    
    
    /**
	 * Tank style driving for the DriveTrain. 
	 * @param left Speed in range [-1,1]
	 * @param right Speed in range [-1,1]
	 */
    public void drive(double left, double right){
    	leftMotor.set(-left);
		rightMotor.set(right);
    }
    
    /*
     * get the range value from the range finder
     * 
     * @return the value in inches 
     */
    public double getRange(){
    	return (rangeFinder.pidGet() * 100 * (5.0/4.88)) / 2.54;
    }
    
    public void log(){
    	SmartDashboard.getNumber("Range Finder", getRange());
    }
    
}

