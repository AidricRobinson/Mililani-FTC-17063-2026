package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;



public class Constants {
    public static class EncoderConstants{
        public static final double kCOUNTS_PER_ROTATION = 8192;
        public static final double kGEAR_DRIVE_REDUCTION = 1;//idk
        public static final double kWHEEL_DIAMETER = 4.094;
        public static final double kWHEEL_CIRCUMFERENCE = kWHEEL_DIAMETER * Math.PI;
        public static final double kCOUNTS_PER_INCH = (kCOUNTS_PER_ROTATION * kGEAR_DRIVE_REDUCTION) / kWHEEL_CIRCUMFERENCE;
    }

    public static class MotorConstants {
        public static final DcMotorEx.Direction shooterDirection = DcMotorEx.Direction.FORWARD;
        public static final DcMotorEx.Direction intakeDirection = DcMotorEx.Direction.FORWARD;
    }

    public static class WaitTime {
        public static final int supportAutoWait = 10000;//miliseconds
    }
}
