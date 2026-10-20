package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class FeederSubsystem {
    CRServo feeder;

    public FeederSubsystem(OpMode opMode)
    {
        feeder = opMode.hardwareMap.get(CRServo.class, "FeederServo");

    }
    public void setPower(double power){
        feeder.setPower(power);
    }

    public void shutdown(){
        feeder.setPower(0);
    }
}
