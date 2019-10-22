package org.firstinspires.ftc.team8741;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous", group = "Bot")
//@Disabled
public class AutoTest extends LinearOpMode {

    private Bot robot = new Bot(this);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        robot.encoderDrive(1, -10, -10, 10);
        robot.encoderDrive(1, 10, 10, 10);
        robot.encoderDrive(1, -10, -10, 10);
        robot.encoderDrive(1, 10, 10, 10);
    }
}