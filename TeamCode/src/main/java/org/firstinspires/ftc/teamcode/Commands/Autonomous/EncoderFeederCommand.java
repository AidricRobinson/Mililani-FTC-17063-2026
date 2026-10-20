package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;

public class EncoderFeederCommand {
    FeederSubsystem feederSubsystem;
    ElapsedTime elapsedTime;
    double startTime;
    public EncoderFeederCommand(FeederSubsystem feederSubsystem, ElapsedTime elapsedTime){
        this.feederSubsystem = feederSubsystem;
        this.elapsedTime = elapsedTime;
    }
    public void encoderFeederOperate(double power){
        startTime = elapsedTime.milliseconds();
        while(elapsedTime.milliseconds() > startTime + 3000){
            feederSubsystem.setPower(power);
        }
    }
    public void shutdown()
    {
        feederSubsystem.shutdown();
    }
}
