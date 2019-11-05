package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Teleop!", group="Iterative Opmode")

public class Teleop extends LinearOpMode {
    //ita hic est magnumcerebrum tempus
    private Bot robot = new Bot(this);


    @Override

    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        while (opModeIsActive()) {

            robot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);

            robot.setLiftPower(gamepad1.left_trigger);
            robot.setLiftPower(-gamepad1.right_trigger);

            if (gamepad1.y == true) {
                robot.setLatchPower(-0.25);
                sleep(380);
            } else if (gamepad1.x == true) {
                robot.setLatchPower(0.25);
                sleep(400);
            } else {
                robot.setLatchPower(0);
            }

            if (gamepad1.left_bumper == true) {
                robot.setClasp(1);
            }
            else if (gamepad1.right_bumper == true){
                robot.setClasp(0);
            }

            if (gamepad1.a) {
                robot.setLiftPower(1);
            }
            else if (gamepad1.b) {
                robot.setLiftPower(-1);
            }
            else {
                robot.setLiftPower(0);
            }


            telemetry.addData("Front Left", robot.getFrontLeft());
            telemetry.addData("Back Right", robot.getBackRight());
            telemetry.addData("Back Left", robot.getBackLeft());
            telemetry.addData("Front right", robot.getFrontRight());
            telemetry.addData("Gyro", robot.getGyroHeading());
            telemetry.addData("getPower", robot.getFrontLeftPower());
            telemetry.addData("getLatch", robot.getLatchPosition());
            telemetry.addData("Front Left", robot.getFrontLeft());
            telemetry.addData("Back Right", robot.getBackRight());
            telemetry.addData("Back Left", robot.getBackLeft());
            telemetry.addData("Front right", robot.getFrontRight());
            telemetry.update();


        }
    }
}