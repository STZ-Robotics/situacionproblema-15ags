package frc.robot.interfaces;

import com.stzteam.features.marsprocessor.Fallback;
import com.stzteam.mars.models.singlemodule.Data;
import com.stzteam.mars.models.singlemodule.IO;

@Fallback
public interface ArmIO extends IO<ArmIO.ArmInputs> {
  public static class ArmInputs extends Data<ArmInputs> {
    public double currentAngle = 0.0;
    public double targetAngle = 0.0;
    public boolean isAtBottom = false;
    public boolean isAtTop = false;
    public double appliedVoltage = 0.0;
    public double appliedCurrent = 0.0;
  }

  public void moveWithVoltage(double voltage);

  public void moveWithDutyCycle(double dutyCycle);

  public void moveToPos(double pos);

  public void stopMotor();

  public void calibratePos();
}
