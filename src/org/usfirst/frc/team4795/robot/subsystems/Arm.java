package org.usfirst.frc.team4795.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon armMotor;
	
	public Arm(){
		super();
		
		armMotor = new CANTalon(5);
		armMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void log(){
    	SmartDashboard.putNumber("Arm Posistion", armMotor.getPosition());
    }
    
    /*
     * set the speed of the arm motor
     */
    public void setSpeed(double speed){
    	armMotor.set(speed);
    }
    
}

