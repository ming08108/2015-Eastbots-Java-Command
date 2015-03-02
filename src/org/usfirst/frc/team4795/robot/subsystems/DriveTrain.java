package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	private CANJaguar leftMotor, rightMotor; 
	
	
	public DriveTrain(){
		super();
		
		leftMotor = new CANJaguar(RobotMap.leftMotor);
		rightMotor = new CANJaguar(RobotMap.rightMotor);
		
		
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
    
    
}

