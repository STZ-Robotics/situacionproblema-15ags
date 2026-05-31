package frc.robot.interfaces;

import com.stzteam.features.marsprocessor.Fallback;
import com.stzteam.mars.models.singlemodule.Data;
import com.stzteam.mars.models.singlemodule.IO;

@Fallback
public interface ArmIO extends IO<ArmIO.ArmInputs> {
  public static class ArmInputs extends Data<ArmInputs> {
    public double currentAngle = 0.0;
    public double appliedCurrent = 0.0;
    public double currentRps = 0.0;
  }

  public double getPos();

  public double getTorque();

  public double getRps();
}
