package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.ElevatorDown;
import org.usfirst.frc.team4795.robot.commands.ElevatorUp;
import org.usfirst.frc.team4795.robot.commands.RangeAlign;
import org.usfirst.frc.team4795.robot.commands.SpinArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//init joysticks
    private Joystick leftJoy = new Joystick(0);
    private Joystick rightJoy = new Joystick(1);
    
    
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    private Button elevatorUp = new JoystickButton(leftJoy, 6);
    private Button elevatorDown = new JoystickButton(leftJoy, 4);
    
    private Button armIn = new JoystickButton(rightJoy, 5);
    private Button armOut = new JoystickButton(rightJoy, 6);
    
    private Button leftTrigger = new JoystickButton(leftJoy, 1);
    
    public OI(){
    	elevatorUp.whileHeld(new ElevatorUp());
    	elevatorDown.whileHeld(new ElevatorDown());
    	
    	
    	armIn.whileHeld(new SpinArm(0.5));
    	armOut.whileHeld(new SpinArm(-0.5));
    	
    	leftTrigger.whileHeld(new RangeAlign(40));
    	
    }

    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button. 
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    
    public Joystick getLeftJoy(){
    	return leftJoy;
    }
    
    public Joystick getRightJoy(){
    	return rightJoy;
    }
}

