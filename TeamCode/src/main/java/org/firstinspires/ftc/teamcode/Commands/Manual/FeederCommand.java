package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;

public class FeederCommand {
    FeederSubsystem feederSubsystem;
    Gamepad gamepad;

    public FeederCommand(FeederSubsystem feederSubsystem, Gamepad gamepad){
        this.feederSubsystem = feederSubsystem;
        this.gamepad = gamepad;
    }

    public void operate(Gamepad gamepad)
    {
        if(gamepad.left_trigger >= 0.2)
        {
            feederSubsystem.setPower(.5);//tbd
        }
        else {
            feederSubsystem.setPower(0);
        }
    }

    public void Shutdown(){
        feederSubsystem.shutdown();
    }
}
