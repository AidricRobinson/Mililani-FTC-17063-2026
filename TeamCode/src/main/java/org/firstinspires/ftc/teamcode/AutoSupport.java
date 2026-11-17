package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderFeederCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderFlowerCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderFlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderIntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderShooterCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderStrafingCommand;
import org.firstinspires.ftc.teamcode.Commands.Autonomous.EncoderTurningCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

@Autonomous(name = "AutoSupport", group = "LinearOpMode")
public class AutoSupport extends LinearOpMode {
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

    private EncoderShooterCommand encoderShooterCommand;
    private ElapsedTime elapsedTime;

    //add limelight when/if we get to it
    @Override
    public void runOpMode() {
        elapsedTime = new ElapsedTime();

        flywheelSubsystem = new FlywheelSubsystem(this);
        mecanumDriveSubsystem = new MecanumDriveSubsystem(this.hardwareMap, this);
        feederSubsystem = new FeederSubsystem(this);
        flowerSubsystem = new FlowerSubsystem(this);
        intakeSubsystem = new IntakeSubsystem(this);



        encoderFeederCommand = new EncoderFeederCommand(feederSubsystem, elapsedTime);
        encoderDriveCommand = new EncoderDriveCommand(mecanumDriveSubsystem, this, telemetry);
        encoderFlywheelCommand = new EncoderFlywheelCommand(flywheelSubsystem, elapsedTime);
        encoderStrafingCommand = new EncoderStrafingCommand(mecanumDriveSubsystem, this, telemetry);
        encoderTurningCommand = new EncoderTurningCommand(mecanumDriveSubsystem, this, telemetry  );
        encoderIntakeCommand = new EncoderIntakeCommand(intakeSubsystem, elapsedTime);

        encoderShooterCommand = new EncoderShooterCommand(intakeSubsystem, feederSubsystem, flywheelSubsystem, elapsedTime);

        ;

        waitForStart();
        //wait to shoot
        //sleep(Constants.WaitTime.supportAutoWait);

        //shoot
//        encoderFlywheelCommand.EncoderFlywheelOperate(.5);
//        sleep(2000);
//        encoderIntakeCommand.EncoderIntakeOperate(.45);
//        encoderFeederCommand.encoderFeederOperate(1);
//        sleep(5000);
//        encoderFlywheelCommand.shutdown();
//        encoderIntakeCommand.shutdown();
//        encoderFeederCommand.shutdown();
        encoderShooterCommand.EncoderShooterOperate(5);

        //park
        encoderDriveCommand.EncoderDriveOperate(-14, "BACKWARD");
        encoderStrafingCommand.EncoderDriveOperate(-60, "LEFT");

















    }
}