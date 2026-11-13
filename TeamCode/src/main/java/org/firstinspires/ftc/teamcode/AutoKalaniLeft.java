package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderFeederCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderFlowerCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderFlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderIntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderStrafingCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderTurningCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

@Autonomous(name = "AutoKalaniLeft", group = "LinearOpMode")
public class AutoKalaniLeft extends LinearOpMode {
    private FeederSubsystem feederSubsystem;
    private FlowerSubsystem flowerSubsystem;
    private FlywheelSubsystem flywheelSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    private EncoderDriveCommand encoderDriveCommand;
    private EncoderFeederCommand encoderFeederCommand;
    private EncoderFlowerCommand encoderFlowerCommand;
    private EncoderFlywheelCommand encoderFlywheelCommand;
    private EncoderStrafingCommand encoderStrafingCommand;
    private EncoderTurningCommand encoderTurningCommand;
    private EncoderIntakeCommand encoderIntakeCommand;
    private ElapsedTime elapsedTime;

    @Override
    public void runOpMode()
    {
        flywheelSubsystem = new FlywheelSubsystem(this);
        mecanumDriveSubsystem = new MecanumDriveSubsystem(this.hardwareMap, this);
        feederSubsystem = new FeederSubsystem(this);
        flowerSubsystem = new FlowerSubsystem(this);
        intakeSubsystem = new IntakeSubsystem(this);


        encoderFeederCommand = new EncoderFeederCommand(feederSubsystem, elapsedTime);
        encoderDriveCommand = new EncoderDriveCommand(mecanumDriveSubsystem, this, telemetry);
        encoderFlywheelCommand = new EncoderFlywheelCommand(flywheelSubsystem, elapsedTime);
        encoderStrafingCommand = new EncoderStrafingCommand(mecanumDriveSubsystem,this, telemetry);

        encoderIntakeCommand = new EncoderIntakeCommand(intakeSubsystem, elapsedTime);


        waitForStart();
        encoderStrafingCommand.EncoderDriveOperate(-1000, "LEFT");
    }
}
