package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name="practoceAutonomus", group="auto")
public class PracticeAuto extends LinearOpMode {

    private PracticeBot robot = new PracticeBot(this);

    @Override

    public void runOpMode() throws InterruptedException{

        robot.init(hardwareMap);
        waitForStart();
        robot.setDistance(30);
        robot.turnDegrees(90);
        robot.setDistance(15);
        robot.turnDegrees(90);
        robot.setDistance(30);
        robot.turnDegrees(90);
        robot.setDistance(15);
        robot.turnDegrees(90);

    }



}
