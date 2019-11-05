package org.firstinspires.ftc.team8741;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PracticeBot {
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private LinearOpMode opMode = null;
    private HardwareMap hwMap = null;
    private DcMotor leftIntake = null;
    private DcMotor rightIntake = null;
    private DcMotor lifter1 = null;
    private Servo closer1 = null;
    private Servo spinner = null;
    private DcMotor latcher=null;

    public PracticeBot(LinearOpMode opMode) {
        this.opMode = opMode;
    }
    public void init(HardwareMap ahwmap){
        hwMap = ahwmap;

        frontLeft =hwMap.get(DcMotor.class, "frontLeft");
        frontRight =hwMap.get(DcMotor.class, "frontRight");
        backLeft =hwMap.get(DcMotor.class, "backLeft");
        backRight =hwMap.get(DcMotor.class, "backRight");
        leftIntake =hwMap.get(DcMotor.class, "leftIntake");
        rightIntake =hwMap.get(DcMotor.class, "rightIntake");
        lifter1 =hwMap.get(DcMotor.class, "lifter");
        closer1 =hwMap.get(Servo.class, "closer");
        spinner =hwMap.get(Servo.class, "spinner");
        latcher =hwMap.get(DcMotor.class,"latcher");
    }
    public void setPower(double leftPower, double rightPower){

        frontRight.setPower(rightPower);
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);
        backRight.setPower(rightPower);


    }
    public void setIntakePower(double intakeLeft, double intakeRight){
        leftIntake.setPower(intakeLeft);
        rightIntake.setPower(intakeRight);
    }
    public void lifterPower(double liftPower){
        lifter1.setPower(liftPower);
    }
    public void setCloserPosition(double closerPosition){
        closer1.setPosition(closerPosition);
    }
    public void setSpinnerPosition(double spinPosition){
        spinner.setPosition(spinPosition);
    }
    public void setLatcherPower(double latcherPower){
        latcher.setPower(latcherPower);
    }



}

