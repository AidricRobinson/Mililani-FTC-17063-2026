package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Constants;


public class IntakeSubsystem {
    DcMotorEx intakeMotor;

    public IntakeSubsystem(OpMode opMode)
    {
        intakeMotor = opMode.hardwareMap.get(DcMotorEx.class, "intakeMotor");

        intakeMotor.setDirection(Constants.MotorConstants.intakeDirection);
        intakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);

    }
    public void setPower(double power){
        intakeMotor.setPower(power);
    }

    public void setVelocity(double velocity)
    {
        intakeMotor.setVelocity(velocity);
    }

    public double getVelocity()
    {
        return intakeMotor.getVelocity();
    }
    public void shutdown()
    {
        intakeMotor.setPower(0);
    }
}
