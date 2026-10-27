package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class FlywheelSubsystem {
    DcMotorEx FlywheelMotor;

    public FlywheelSubsystem(OpMode opMode) {
        FlywheelMotor  = opMode.hardwareMap.get(DcMotorEx.class, "Flywheel");
        FlywheelMotor.setDirection(Constants.MotorConstants.shooterDirection);
        FlywheelMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        FlywheelMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }
    public void setFlywheelPower(double power){
        FlywheelMotor.setPower(power);
    }
    public double getFlywheelEncoder(){
        return FlywheelMotor.getCurrentPosition();
    }
    public void setRPM(double rpm){
        FlywheelMotor.setVelocity(rpm * 28 / 60);
    }
    public double getRPM(){
        return FlywheelMotor.getVelocity() / 28 * 60;
    }
    public void shutdown(){
        FlywheelMotor.setPower(0);
    }
}
