package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;



public class EncoderIntakeCommand {
    IntakeSubsystem intakeSubsystem;
    Telemetry telemetry;
    ElapsedTime elapsedTime;
    double startTime;

    public EncoderIntakeCommand(IntakeSubsystem intakeSubsystem, ElapsedTime elapsedTime)
    {
        this.intakeSubsystem = intakeSubsystem;
        this.elapsedTime = elapsedTime;

    }

    public void EncoderIntakeOperate(double power)
    {
        startTime = elapsedTime.milliseconds();
        while(elapsedTime.milliseconds() < startTime + 2000)
        {
            intakeSubsystem.setPower(power);
        }
    }

    public void shutdown()
    {
        intakeSubsystem.shutdown();
    }
}
