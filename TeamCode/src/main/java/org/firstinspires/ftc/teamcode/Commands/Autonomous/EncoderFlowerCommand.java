package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;

public class EncoderFlowerCommand {
    FlowerSubsystem flowerSubsystem;
    ElapsedTime elapsedTime;
    double startTime;

    public EncoderFlowerCommand(FlowerSubsystem flowerSubsystem, ElapsedTime elapsedTime)
    {
        this.flowerSubsystem = flowerSubsystem;
        this.elapsedTime = elapsedTime;
    }

    public void encoderFlowerOperate(Double pos)
    {
        startTime = elapsedTime.milliseconds();
        while(elapsedTime.milliseconds() < startTime + 2000)//time is tbd
        {
            flowerSubsystem.setFlowerServoPosition(pos);
        }
    }

    public void shutdown()
    {
        flowerSubsystem.shutdown();
    }
}
