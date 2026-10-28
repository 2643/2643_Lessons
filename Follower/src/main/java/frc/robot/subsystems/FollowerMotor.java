// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


// Import these by using autofill or quick fix
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// The motor is not continuously running we will be making a toggle command to run the motor and then stop it

public class FollowerMotor extends SubsystemBase {
  // Make your two motors one is the master and one is the follower
  TalonFX master = new TalonFX(0);
  TalonFX follower = new TalonFX(1);

  public FollowerMotor() {
    // Set the other motor to follow the other motor the parameters is the leader motor port and if its aligned/opposed 
    follower.setControl(new Follower(0, MotorAlignmentValue.Aligned));
  }

  // The same move method from the first unit
  public void moveMaster(double speed) {
    master.setControl(new DutyCycleOut(speed));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
