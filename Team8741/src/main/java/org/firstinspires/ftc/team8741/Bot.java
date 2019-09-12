package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Bot {
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private HardwareMap hwMap = null;

    private LinearOpMode opMode = null;
    public Bot(LinearOpMode opMode) {
        this.opMode = opMode;
    }


    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        frontLeftDrive = hwMap.get(DcMotor.class, "left");
        frontRightDrive = hwMap.get(DcMotor.class, "right");
        backLeftDrive = hwMap.get(DcMotor.class, "left");
        backRightDrive = hwMap.get(DcMotor.class, "right");
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
}

    public void setPower(double leftPower, double rightPower) {
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);
    }

}
