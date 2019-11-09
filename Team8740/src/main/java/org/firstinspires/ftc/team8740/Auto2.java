package org.firstinspires.ftc.team8740;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="auto2", group="auto")
public class Auto2 extends LinearOpMode {
    private Bot robot = new Bot(this);

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        waitForStart();
        robot.encoderDrive(0.4,3, 3, 30);
        robot.encoderTurn(0.8,30,30);
        robot.setLift(-0.4,0.4);
        robot.encoderDrive(0.4,13,13,30);
        robot.setLift(0.2,-0.2);
        sleep(1500);
        robot.encoderDrive(0.4,-31,-30,30);
        sleep(10);
        robot.setLift(-0.4,0.4);
        sleep(1000);
        robot.setLift(-0.1,0.1);
        sleep(25000);
        robot.setLift(0,0);

        /*
        robot.encoderDrive(0.4,10, 10, 30);
        robot.encoderTurn (0.4,-45, 30);
        robot.encoderDrive(0.4, 5,5,30);
        robot.encoderTurn (0.4,45, 30);
        robot.setLift(-0.4,0.4);
        robot.encoderDrive(0.4,6,6,30);
        robot.setLift(0.2,-0.2);
        robot.setPower(0,0);
        sleep(1000);
        robot.encoderDrive( 0.3,-19,-19,30);
        sleep(10);
        robot.setLift(-0.4,0.4);
        sleep(1000);
        robot.setLift(-0.1,0.1);
        sleep(25000);
        robot.setLift(0,0);
        */


    }
}

