package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.interfaces.ShooterIO;

public class Shooter implements ShooterIO {
  private SparkMax flywheel;
  private RelativeEncoder flywheelEncoder;

  public Shooter() {
    this.flywheel = new SparkMax(0, MotorType.kBrushless);
    flywheelEncoder = flywheel.getEncoder();
    SparkMaxConfig config = new SparkMaxConfig();
    config.encoder.positionConversionFactor((1 / 3) / 60);
    flywheel.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void moveWithVoltage(double voltage) {
    flywheel.setVoltage(voltage);
  }

  @Override
  public void moveToTargetSpeed(double targetSpeed) {
    flywheel.set(targetSpeed);
  }

  @Override
  public void stopMotor() {
    flywheel.stopMotor();
  }

  @Override
  public void invertMotor() {
  }

  @Override
  public void updateInputs(ShooterInputs inputs) {
    inputs.currentRps = flywheelEncoder.getVelocity();
  }
}
