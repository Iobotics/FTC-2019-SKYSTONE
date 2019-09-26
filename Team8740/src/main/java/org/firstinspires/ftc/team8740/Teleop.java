package org.firstinspires.ftc.team8740;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name="Basic: OpMode", group="Iterative Opmode")

public class Teleop extends LinearOpMode{
    private Bot robot = new Bot(this);

    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;

    @Override
    public void runOpMode() throws InterruptedException {

       robot.init(hardwareMap);
       waitForStart();
       while(opModeIsActive()) {
           if(gamepad1.a){
               robot.setPower(gamepad1.left_stick_y *0.5,gamepad1.right_stick_y *0.5);
           }
           else{ robot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);}

           if(gamepad1.left_trigger > 0.5){
               robot.setIntake(gamepad1.left_trigger, -gamepad1.left_trigger);
           }
           else if(gamepad1.right_trigger > 0.5){
               robot.setIntake(-gamepad1.right_trigger, gamepad1.right_trigger);
           }
           else if(gamepad1.left_bumper == true){
              robot.setIntake( 1, 1);
          }
           else if(gamepad1.right_bumper == true){
              robot.setIntake(-1, -1);
           }
          else{
              robot.setIntake(0,0);
          }
       }

    }

}
