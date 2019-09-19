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
    private Servo servoRight = null;
    private Servo servoLeft = null;

    private LinearOpMode opMode = null;
    public Bot(LinearOpMode opMode) {
        this.opMode = opMode;
    }


    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        frontLeftDrive = hwMap.get(DcMotor.class, "frontleft");
        frontRightDrive = hwMap.get(DcMotor.class, "frontright");
        backLeftDrive = hwMap.get(DcMotor.class, "backleft");
        backRightDrive = hwMap.get(DcMotor.class, "backright");
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        servoLeft = hwMap.get(Servo.class,"leftservo");
        servoRight = hwMap.get(Servo.class,"rightservo");


}

    public void setPower(double leftPower, double rightPower) {
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);

    }

    public void setPosition(double position) {
        servoLeft.setPosition(position);
        servoRight.setPosition(position);
    }

    public double getLeftPosition() {
        return servoLeft.getPosition();
    }

    public double getRightPosition() {
        return servoRight.getPosition();

    }
    private ElapsedTime runtime = new ElapsedTime();

    public double getRunTime (){
        return runtime.seconds();
    }
}
