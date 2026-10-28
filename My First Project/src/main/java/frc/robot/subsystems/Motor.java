// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Create a subsystem by right clicking the "subsystems" folder and press "Create a new class/command" and click subsystem

// Reminder to install VendorDeps on the left side bar

// To do imports quickly hover over red lines to press quick fix and import the class

public class Motor extends SubsystemBase {
  //Below the class creation: Make your objects/variables here
  TalonFX motor = new TalonFX(0); // Create your first motor (class is TalonFX)
 

  //Constructor: Put your configurations here
  public Motor() {
    moveMotor(0.1); // Calls the method that you previously made runs the motor at 0.1 speed when enabling the robot

    // Now move to RobotContainer to finish your project
  }


  //Below the constructor: Make your methods here
  public void moveMotor(double speed) { // Method that doesn't return anything and asks for a double parameter
    System.out.println(speed); // Prints the speed to show what is being run
    motor.setControl(new DutyCycleOut(speed)); // Method to run a motor "*motorname*.setControl" in the () is an object that is the control mode of the motor

    // DutyCycleOut: Runs the motor continuously under a set speed (0.1 - 1)
    // Follower: Follows another motor's movement
    // MotionMagicVoltage: Position control with more configuration opportunitites

  }

  @Override
  public void periodic() {
    // Ignore this for now
  }
}



