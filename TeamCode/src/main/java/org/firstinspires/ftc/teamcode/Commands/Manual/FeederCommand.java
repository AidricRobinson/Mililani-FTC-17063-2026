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

    public void operate()
    {
        if(gamepad.right_bumper)
        {
            feederSubsystem.setPower(1);//tbd
        }
        else {
            feederSubsystem.setPower(0);
        }
    }

    public void Shutdown(){
        feederSubsystem.shutdown();
    }
}
