package org.firstinspires.ftc.teamcode;

public class PIDController {
    private double kP;
    private double setPoint; // target variable
    private double error;
    private double processVariable; // current position
    private double kFF;
    private double output; // power to the robot

    private double integral;
    private double kI;
    private double derivative;
    private double kD;
    private double prevError = 0;
    private double prevPos = 0;
    public PIDController (double kP, double kI, double kD, double kFF) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kFF = kFF;

        integral = 0;
    }
    public void createSetPoint(double setPoint){
        this.setPoint = setPoint;
    }
    public void setProcessVariable(double processVariable){

        this.processVariable = processVariable;
    }
    public double getError(){
        prevError = error;
        error = setPoint - processVariable;
        return error;
    }
    public double getOutput(){
        error = getError();
        integral += error;
        derivative = (error - prevError) / 0.02;

        output = kP * error + kI * integral + kD * derivative + Math.copySign(kFF, error);
        return output;
    }
}

