package org.firstinspires.ftc.team8740;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name="teleop", group="teleop")

public class Teleop extends LinearOpMode {
    private Bot robot = new Bot(this);

    //slowmode(tm)
    boolean slowMode = false;
    boolean buttonApressed = false;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("encoder 1", robot.getBackLeft());
            telemetry.addData("encoder 2", robot.getFrontLeft());
            telemetry.addData("encoder 3", robot.getBackRight());
            telemetry.addData("encoder 4", robot.getFrontRight());
            telemetry.update();
            if (gamepad1.a && buttonApressed == false) {
                slowMode = !slowMode;
                buttonApressed = true;
            } else if (gamepad1.a) {
            } else {
                buttonApressed = false;
            }
            if (slowMode) {

                robot.setPower(-gamepad1.left_stick_y * 0.3, -gamepad1.right_stick_y * 0.3);


            } else {
                robot.setPower(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
            }
            //foundation 1
            if (gamepad1.dpad_left == true) {
                robot.setIntake(1, -1);
            }
            //foundation 2
            else if (gamepad1.dpad_right) {
                robot.setIntake(-1, 1);
            } else if (gamepad1.left_bumper == true) {
                robot.setIntake(1, 1);
            } else if (gamepad1.right_bumper == true) {
                robot.setIntake(-1, -1);
            } else {
                robot.setIntake(0, 0);
            }
            if (gamepad1.left_trigger > 0.5) {
                robot.setLift(0.5, -0.5);
            } else if (gamepad1.right_trigger > 0.5) {
                robot.setLift(-0.5, 0.5);
            } else robot.setLift(0, 0);

            if (gamepad1.x && gamepad1.y) {
                robot.setCapStone(1);

            } else {
                robot.setCapStone(0);
            }

        }

    }
}

