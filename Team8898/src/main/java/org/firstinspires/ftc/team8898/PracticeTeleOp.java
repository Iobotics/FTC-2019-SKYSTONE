package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.team8898.PracticeBot;

@TeleOp(name="Practice: teleOp", group="asd")

public class PracticeTeleOp extends LinearOpMode {

    private PracticeBot PracticeBot = new PracticeBot(this);
    double leftPower;
    double rightPower;

    @Override
    public void runOpMode() throws InterruptedException{
        PracticeBot.init(hardwareMap);
        PracticeBot.setArm2Position(0.5);
        PracticeBot.setArmPosition1(0.5);

        waitForStart();
        while (opModeIsActive()) {

            telemetry.addData("arm1", PracticeBot.getArmOnePosition());
            telemetry.addData("arm2", PracticeBot.getArmTwoPosition());
            telemetry.update();
            PracticeBot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);


            if(gamepad1.right_trigger>0.5){
                PracticeBot.setArmPosition1(1);
                PracticeBot.setArm2Position(0);

            }
            else
                if(gamepad1.left_trigger>0.5){
                PracticeBot.setArmPosition1(0);
                PracticeBot.setArm2Position(1);
            }
                else {PracticeBot.setArm2Position(0.5);
                        PracticeBot.setArmPosition1(0.7);
            }

        }


    }


}
