package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.interfaces.ArmIO;

public class Arm implements ArmIO {

  private final TalonFX armMotor;
  private TalonFXConfigurator configurator;
  private TalonFXConfiguration configuration;

  public Arm(int motorID) {
    this.armMotor = new TalonFX(motorID);

    this.configuration = new TalonFXConfiguration();
    this.configurator = armMotor.getConfigurator();
    configuration.Feedback.SensorToMechanismRatio = 75;
    configurator.apply(configuration);
  }

  @Override
  public double getPos() {
    return armMotor.getPosition().getValueAsDouble();
  }

  @Override
  public double getTorque() {
    return armMotor.getStatorCurrent().getValueAsDouble();
  }

  @Override
  public double getRps() {
    return armMotor.getVelocity().getValueAsDouble();
  }

  @Override
  public void updateInputs(ArmInputs inputs) {
    inputs.currentAngle = armMotor.getPosition().getValueAsDouble();
    inputs.appliedCurrent = armMotor.getStatorCurrent().getValueAsDouble();
    inputs.currentRps = armMotor.getVelocity().getValueAsDouble();
  }
}
