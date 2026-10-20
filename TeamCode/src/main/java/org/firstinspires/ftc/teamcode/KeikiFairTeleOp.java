package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Commands.Manual.FeederCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.FlowerCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.FlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.KeikiFairCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.LimeLightCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

    @TeleOp(name="KeikiFairTeleOp")

    public class KeikiFairTeleOp extends OpMode {
        //asdfasfasdfasf
        private KeikiFairCommand keikiFairCommand;
        private FlywheelSubsystem flywheelSubsystem;
        private IntakeSubsystem intakeSubsystem;
        private FeederSubsystem feederSubsystem;
        private MecanumDriveSubsystem mecanumDriveSubsystem;

        private FeederCommand feederCommand;





        //When you 8 initialize
        public void init () {
            //mecanumDriveSubsystem = new MecanumDriveSubsystem(this.hardwareMap,this);

            flywheelSubsystem = new FlywheelSubsystem(this);
            intakeSubsystem = new IntakeSubsystem(this);
            feederSubsystem = new FeederSubsystem(this);
            keikiFairCommand = new KeikiFairCommand(flywheelSubsystem, intakeSubsystem, feederSubsystem, gamepad1);
            mecanumDriveSubsystem = new MecanumDriveSubsystem(this.hardwareMap, this);
            feederCommand = new FeederCommand(feederSubsystem, gamepad1);


        }

        @Override
        public void loop(){
            //mecanumDriveSubsystem.operate(gamepad1, telemetry);
            keikiFairCommand.Operate(gamepad1);
            mecanumDriveSubsystem.operate(gamepad1, telemetry);
            feederCommand.operate();
        }
        public void stop(){
            //mecanumDriveSubsystem.shutdown();
            keikiFairCommand.Shutdown();
            mecanumDriveSubsystem.shutdown();
            feederCommand.Shutdown();
        }
    }


