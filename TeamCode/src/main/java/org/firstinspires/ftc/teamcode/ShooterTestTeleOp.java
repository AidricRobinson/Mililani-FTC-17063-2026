package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.Manual.FeederCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.FlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.LimeLightCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;


@TeleOp(name="ShooterTestTeleOp")
public class ShooterTestTeleOp extends OpMode{

    FlywheelSubsystem flywheelSubsystem;
    PIDControllerShooter pidControllerShooter;
    private IntakeSubsystem intakeSubsystem;
    private IntakeCommand intakeCommand;
    private FeederSubsystem feederSubsystem;
    private FeederCommand feederCommand;
    boolean toggle1 = true;
    boolean toggle2 = true;// eletric boogaloo

    boolean toggle3 = true; //step
    public static double kp = 0.0036;

    public static double kS = 0.02;
    public static double kV = .00019;
    public static double kff = kV * 2600 + kS;
    public double[] stepSizes= {.1, .01, .001, .0001, .00001, .000001};
    public int stepIndex = 0;


        @Override
        public void init() {
            flywheelSubsystem = new FlywheelSubsystem(this);
            intakeSubsystem = new IntakeSubsystem(this);
            intakeCommand = new IntakeCommand(intakeSubsystem,gamepad1,gamepad2);

            feederSubsystem = new FeederSubsystem(this);
            feederCommand = new FeederCommand(feederSubsystem, gamepad2);

        }
        @Override
        public void loop() {
            pidControllerShooter = new PIDControllerShooter(kp, kV, kS);
            pidControllerShooter.createSetPoint(2600);
            pidControllerShooter.setProcessVariable(flywheelSubsystem.getRPM());
            //intakeCommand.operate();
            feederCommand.operate();





            telemetry.addData("RPM: ", flywheelSubsystem.getRPM());
            telemetry.addData("Error: ", 2600 -flywheelSubsystem.getRPM());
            telemetry.addData("kP", kp);
            telemetry.addData("kff: ", kff);
            telemetry.addData("Step Size: ", stepSizes[stepIndex]);
            telemetry.update();




            if (gamepad1.right_trigger > 0.2){

                flywheelSubsystem.setFlywheelPower(pidControllerShooter.getOutput());

            }
            else if (gamepad1.dpad_down){
                flywheelSubsystem.setFlywheelPower(1);
            }
            else {
                flywheelSubsystem.setFlywheelPower(0);
            }



            if(gamepad1.a && toggle1){
                kp += stepSizes[stepIndex];
                toggle1 = false;
            }
            else if(gamepad1.b && toggle1){
                kp-= stepSizes[stepIndex];
                toggle1 = false;
            } else if (!gamepad1.a && !gamepad1.b && !toggle1) {
                toggle1 = true;
            }

            if(gamepad1.x && toggle2){
                //kV += stepSizes[stepIndex];
                toggle2 = false;
            }
            else if(gamepad1.y && toggle2){
                //kkV -= stepSizes[stepIndex];
                toggle2 = false;
            } else if (!gamepad1.x && !gamepad1.y && !toggle2) {
                toggle2 = true;
            }

            //stepIndex
            if(gamepad1.right_bumper && toggle3)
            {
                stepIndex = (stepIndex + 1) % stepSizes.length;
                toggle3 = false;
            }
            else if(!gamepad1.right_bumper && !toggle3)
            {
                toggle3 = true;
            }




        }
        public void stop(){
            flywheelSubsystem.shutdown();
            intakeSubsystem.shutdown();
            feederSubsystem.shutdown();
        }
    }


