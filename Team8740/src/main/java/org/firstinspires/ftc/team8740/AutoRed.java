package org.firstinspires.ftc.team8740;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="autoRed", group="auto")
public class AutoRed extends LinearOpMode {
    private Bot robot = new Bot(this);

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        waitForStart();
        robot.encoderDrive(0.4,3, 3, 2);
        robot.gyroTurn(30,0.4);
        robot.setLift(-0.4,0.4);
        robot.encoderDrive(0.3,12.5,12.5,10);
        robot.setLift(0.2,-0.2);
        sleep(1500);
        robot.encoderDrive(0.3,-30,-32,30);
        sleep(1000);
        robot.setLift(-0.4,0.4);
        sleep(1500);
        robot.setLift(-0.1,0.1);

        while(opModeIsActive());


    }
}

