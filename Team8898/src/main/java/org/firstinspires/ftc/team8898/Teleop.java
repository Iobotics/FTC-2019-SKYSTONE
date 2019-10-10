package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Teleop", group="Iterative Opmode")

public class Teleop extends LinearOpMode {
    //ita hic est magnumcerebrum tempus
    private Bot robot = new Bot(this);


    @Override

    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        robot.setArm2Position(0.5);
        robot.setArmPosition1(0.5);
        waitForStart();

        while (opModeIsActive()) {
            robot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
            if (gamepad1.left_bumper == true) {
                robot.setLatchPower(0.25);
            } else if (gamepad1.right_bumper == true) {
                robot.setLatchPower(-0.25);
            } else {
                robot.setLatchPower(0);
            }


            telemetry.addData("Front Left", robot.getFrontLeft());
            telemetry.addData("Back Right", robot.getBackRight());
            telemetry.addData("Back Left", robot.getBackLeft());
            telemetry.addData("Front right", robot.getFrontRight());
            telemetry.addData("Gyro", robot.getGyroHeading());
            telemetry.addData("getPower", robot.getFrontLeftPower());
            telemetry.addData("arm1", robot.getArmOnePosition());
            telemetry.addData("arm2", robot.getArmTwoPosition());
            telemetry.update();
            if (gamepad1.left_trigger > 0.5) {
                robot.setFlyPower(1);
            } else if (gamepad1.right_trigger > 0.5) {
                robot.setFlyPower(-1);
            } else {
                robot.setFlyPower(0);
            }
            if (gamepad1.x) {
                robot.setScrewPower(0.5);
            } else if (gamepad1.y) {
                robot.setScrewPower(-0.5);
            } else {
                robot.setScrewPower(0);
            }
            /*
            if(gamepad1.right_trigger>0.5){
               robot.setArmPosition1(1);
                robot.setArm2Position(0);
            }
            else if(gamepad1.left_trigger>0.5){
                robot.setArmPosition1(0);
                robot.setArm2Position(1); //big bot
            }
            else {robot.setArm2Position(0.6);
               robot.setArmPosition1(0.4);
            }
            */


            telemetry.addData("Front Left", robot.getFrontLeft());
            telemetry.addData("Back Right", robot.getBackRight());
            telemetry.addData("Back Left", robot.getBackLeft());
            telemetry.addData("Front right", robot.getFrontRight());
            telemetry.update();


        }
    }
}