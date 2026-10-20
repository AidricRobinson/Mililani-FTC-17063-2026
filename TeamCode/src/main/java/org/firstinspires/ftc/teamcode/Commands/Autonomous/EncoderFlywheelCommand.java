package org.firstinspires.ftc.teamcode.Commands.Autonomous;


import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;

public class EncoderFlywheelCommand {
    FlywheelSubsystem flywheelSubsystem;
    Telemetry telemetry;
    ElapsedTime elapsedTime;
    double startTime;

    public EncoderFlywheelCommand(FlywheelSubsystem flywheelSubsystem, ElapsedTime elapsedTime){
        this.flywheelSubsystem = flywheelSubsystem;
        this.elapsedTime = elapsedTime;
    }
    public void EncoderFlywheelOperate(double power){
        startTime = elapsedTime.milliseconds();
        while(elapsedTime.milliseconds() < startTime + 2000) {//tbd
            flywheelSubsystem.setFlywheelPower(power);
        }
    }
    public void shutdown(){
        flywheelSubsystem.shutdown();
    }
}
