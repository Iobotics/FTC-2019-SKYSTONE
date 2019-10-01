package org.firstinspires.ftc.team8741;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="Basic: OpMode", group="Iterative Opmode")

public class teleop extends LinearOpMode {
    private Bot robot = new Bot(this);

    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;
    double lifterPower;


    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            robot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);


            robot.setLifter(gamepad1.a, gamepad1.b);

            robot.setSpinner(gamepad1.left_bumper, gamepad1.right_bumper);
            /*telemetry.addData("Lifter 1", robot.getLifter1Servo());*/
            //telemetry.addData("Lifter 1", robot.getLifter1Servo());
            //telemetry.addData("Lifter 1", robot.getLifter1Servo());

            telemetry.update();

            robot.setCloser(gamepad1.y, gamepad1.x);


        }
    }


}