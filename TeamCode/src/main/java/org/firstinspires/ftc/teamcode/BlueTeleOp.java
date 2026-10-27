package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.Manual.FeederCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.FlowerCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.FlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.LimeLightCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;

@TeleOp(name="BlueTeleOp")

public class BlueTeleOp extends OpMode {
    //declaring subsystems and commands here
    private FlywheelSubsystem flywheelSubsystem;
    private FlywheelCommand flywheelCommand;

    private IntakeSubsystem intakeSubsystem;
    private IntakeCommand intakeCommand;

    private FlowerSubsystem flowerSubsystem;
    private FlowerCommand flowerCommand;

    private FeederSubsystem feederSubsystem;
    private FeederCommand feederCommand;

    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private Limelight3A limelight;
    private LimeLightCommand limeLightCommand;




    //When you 8 initialize
    public void init () {
        mecanumDriveSubsystem = new MecanumDriveSubsystem(this.hardwareMap,this);

        flywheelSubsystem = new FlywheelSubsystem(this);
        flywheelCommand = new FlywheelCommand(flywheelSubsystem, gamepad2/*, limeLightCommand*/, telemetry);

        intakeSubsystem = new IntakeSubsystem(this);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad1, gamepad2);

        feederSubsystem = new FeederSubsystem(this);
        feederCommand = new FeederCommand(feederSubsystem, gamepad2);

        flowerSubsystem = new FlowerSubsystem(this);
        flowerCommand = new FlowerCommand(flowerSubsystem, gamepad1);



    }

    @Override
    public void loop(){
        //Limelight is declared in the loop so that it can keep updating the values?
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(1);
        limelight.setPollRateHz(60);
        limelight.start();
        limeLightCommand = new LimeLightCommand(mecanumDriveSubsystem, limelight, gamepad1, telemetry);


        mecanumDriveSubsystem.operate(gamepad1, telemetry);
        flywheelCommand.operate();
        intakeCommand.operate();
        feederCommand.operate();
        flowerCommand.operate();

    }
    public void stop(){
        mecanumDriveSubsystem.shutdown();
        flywheelSubsystem.shutdown();
        intakeSubsystem.shutdown();
        flowerSubsystem.shutdown();
        feederSubsystem.shutdown();
    }
}