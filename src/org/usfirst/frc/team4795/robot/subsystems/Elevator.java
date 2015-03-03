package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.ManualElevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	
	private CANJaguar winchMotor;
	
	public Elevator(){
		winchMotor = new CANJaguar(RobotMap.winchMotor);
		winchMotor.setPositionMode(CANJaguar.kQuadEncoder, 2048, -300, 0, 0);
		
		winchMotor.configSoftPositionLimits(0, 6);
		winchMotor.enableControl(0);
		
		
		
		SmartDashboard.putNumber("encoderSet", 0);
		
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManualElevator());
    }
    
    
    
    /**
     * Sets the position of the winchMotor
     * @param posistion [0, 6]
     */
    public void setPosition(double posistion){
    	winchMotor.set(posistion);
    	
    	SmartDashboard.putNumber("encoder", winchMotor.getPosition());
    }
    
}

