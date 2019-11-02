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

        robot.setLift(-0.4,0.4);
        robot.encoderDrive( 0.4,-17,-17,30);
        robot.setLift(0.1,-0.1);
        robot.setPower(0,0);
        sleep(1000);
        robot.encoderDrive( 0.3,19,19,30);
        robot.setLift(-0.4,0.4);
        sleep(20);
        robot.setLift(-0.1,0.1);
        sleep(25000);
        robot.setLift(0,0);


        /*
        robot.encoderDrive(0.4,-20,-20,30);
        robot.encoderTurn(0.4,-45,30);
        robot.encoderDrive(0.4,-10,-10,30);
        robot.encoderTurn(0.4,-45,30);
        robot.encoderDrive(0.4, -10,-10,30);
        robot.setLift(0.4,0.4);
        */


    }
}
