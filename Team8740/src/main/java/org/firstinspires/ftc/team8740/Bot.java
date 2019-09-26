package org.firstinspires.ftc.team8740;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Bot {
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private HardwareMap hwMap = null;
    private DcMotor intakeLeft = null;
    private DcMotor intakeRight = null;


    private LinearOpMode opMode = null;
    public Bot(LinearOpMode opMode) {
        this.opMode = opMode;
    }


    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        frontLeftDrive = hwMap.get(DcMotor.class, "frontLeft");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRight");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeft");
        backRightDrive = hwMap.get(DcMotor.class, "backRight");
        intakeLeft = hwMap.get(DcMotor.class, "leftIntake");
        intakeRight = hwMap.get(DcMotor.class, "rightIntake");
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
       intakeLeft.setDirection(DcMotor.Direction.FORWARD);
        intakeRight.setDirection(DcMotor.Direction.REVERSE);



}

    public void setPower(double leftPower, double rightPower) {
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);

    }
    public void setIntake(double leftPower, double rightPower){
        intakeLeft.setPower(leftPower);
        intakeRight.setPower(rightPower);
    }




    private ElapsedTime runtime = new ElapsedTime();

    public double getRunTime (){
        return runtime.seconds();
    }
}
