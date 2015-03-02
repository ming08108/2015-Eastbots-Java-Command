package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.ManualElevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	private CANJaguar winchMotor;
	
	public Elevator(){
		winchMotor = new CANJaguar(RobotMap.winchMotor);
		
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManualElevator());
    }
    
    /**
     * Sets the speed of the winchMotor
     * @param speed [-1,1]
     */
    public void setSpeed(double speed){
    	winchMotor.set(speed);
    }
}

