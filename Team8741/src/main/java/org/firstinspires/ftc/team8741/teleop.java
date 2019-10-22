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
            robot.setPower(gamepad2.left_stick_y , gamepad2.right_stick_y );


            //robot.setLifter(gamepad1.a, gamepad1.b);

            //robot.setSpinner(gamepad1.dpad_left, gamepad1.dpad_right);
            /*telemetry.addData("Lifter 1", robot.getLifter1Servo());*/
            telemetry.addData("Encoder", robot.getFrontLeft());
            telemetry.addData("Encoder 2", robot.getBackLeft());
            telemetry.addData("Encoder 3", robot.getFrontRight());
            telemetry.addData("Encoder 4", robot.getBackRight());
            //telemetry.addData("Lifter 1", robot.getLifter1Servo());
            //telemetry.addData("Lifter 1", robot.getLifter1Servo());
            telemetry.addData(" 'neil' degrese", robot.getGyroHeading());
            telemetry.addData("splinter", robot.getSpinner());
            telemetry.addData("adsf", robot.getCloser());
            telemetry.addData("latch", robot.getLatcher());

            telemetry.update();

            robot.setSpinner(gamepad1.y, gamepad1.x);

            robot.setLifter(gamepad1.right_trigger > .5, gamepad1.left_trigger > .5);

            robot.setCloser(gamepad1.a, gamepad1.b);

            robot.setLatcher(gamepad2.a, gamepad2.b);

            robot.slowMode(gamepad2.left_bumper, gamepad2.right_bumper);

            //robot.liftBlock(gamepad2.x, .5, 1);
        }
    }


}