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

@Autonomous(name = "AutoMain", group = "LinearOpMode")
public class AutoMain extends LinearOpMode {
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

    //add limelight when/if we get to it
    @Override
    public void runOpMode()
    {
       elapsedTime = new ElapsedTime();

       flywheelSubsystem = new FlywheelSubsystem(this);
       mecanumDriveSubsystem = new MecanumDriveSubsystem(this.hardwareMap, this);
       feederSubsystem = new FeederSubsystem(this);
       flowerSubsystem = new FlowerSubsystem(this);
       intakeSubsystem = new IntakeSubsystem(this);


       encoderFeederCommand = new EncoderFeederCommand(feederSubsystem, elapsedTime);
       encoderDriveCommand = new EncoderDriveCommand(mecanumDriveSubsystem, this);
       encoderFlywheelCommand = new EncoderFlywheelCommand(flywheelSubsystem, elapsedTime);
       encoderStrafingCommand = new EncoderStrafingCommand(mecanumDriveSubsystem,this);
       encoderTurningCommand = new EncoderTurningCommand(mecanumDriveSubsystem,this);
       encoderIntakeCommand = new EncoderIntakeCommand(intakeSubsystem, elapsedTime)
;

        waitForStart();
        //Initial shoot
        encoderFlywheelCommand.EncoderFlywheelOperate(1);
        encoderFeederCommand.encoderFeederOperate(0.25);
        sleep(5000);
        encoderFlywheelCommand.shutdown();
        encoderFeederCommand.shutdown();

        //Move to garden
        encoderDriveCommand.EncoderDriveOperate(24, "FORWARD");
        sleep(5000);

        encoderTurningCommand.EncoderTurningOperate(-120, "LEFT");
        sleep(5000);
        encoderTurningCommand.shutdown();
        encoderFeederCommand.encoderFeederOperate(0.25);
        encoderDriveCommand.EncoderDriveOperate(50, "FORWARD");
        encoderIntakeCommand.EncoderIntakeOperate(1);
        encoderDriveCommand.EncoderDriveOperatePower(6, 0.2, "FORWARD");
        sleep(5000);
        encoderIntakeCommand.shutdown();

        //Move to shoot again
        encoderDriveCommand.EncoderDriveOperate(-12, "BACKWARD");
        encoderStrafingCommand.EncoderDriveOperate(-12, "RIGHT");
        encoderTurningCommand.EncoderTurningOperate(101, "RIGHT");
        encoderDriveCommand.EncoderDriveOperate(124, "FORWARD");
        encoderTurningCommand.EncoderTurningOperate(169, "LEFT");
        encoderDriveCommand.EncoderDriveOperatePower(-6, 0.2, "BACKWARD");

        //shoot
        encoderFlywheelCommand.EncoderFlywheelOperate(1);
        encoderFeederCommand.encoderFeederOperate(0.25);
        sleep(2000);
        encoderFeederCommand.shutdown();
        encoderFlywheelCommand.shutdown();


        /*park*/
        encoderDriveCommand.EncoderDriveOperate(48,"FORWARD");
        encoderStrafingCommand.EncoderDriveOperate(60,"RIGHT" );



    }
}
