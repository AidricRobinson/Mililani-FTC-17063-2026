package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.PIDControllerShooter;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class EncoderShooterCommand {
    IntakeSubsystem intakeSubsystem;
    FeederSubsystem feederSubsystem;
    FlywheelSubsystem flywheelSubsystem;
    ElapsedTime elapsedTime;
    PIDControllerShooter pidControllerShooter;

    public EncoderShooterCommand(IntakeSubsystem intakeSubsystem, FeederSubsystem feederSubsystem, FlywheelSubsystem flywheelSubsystem, ElapsedTime elapsedTime)
    {
        this.intakeSubsystem = intakeSubsystem;
        this.feederSubsystem = feederSubsystem;
        this.flywheelSubsystem = flywheelSubsystem;
        this.elapsedTime = elapsedTime;
        this.pidControllerShooter = new PIDControllerShooter(0.0025, 0.00019, .002);
        pidControllerShooter.createSetPoint(2600);
    }
    public void EncoderShooterOperate(double seconds)
    {
        double startTime = elapsedTime.seconds();
        double endTime = startTime + seconds;
        while(elapsedTime.seconds() <= endTime)
        {

            pidControllerShooter.setProcessVariable(flywheelSubsystem.getRPM());
            flywheelSubsystem.setFlywheelPower(pidControllerShooter.getOutput());
            if (Math.abs(pidControllerShooter.getError()) <= 100) {
                feederSubsystem.setPower(1);
                intakeSubsystem.setPower(.45);
            }
        }
    }

}
