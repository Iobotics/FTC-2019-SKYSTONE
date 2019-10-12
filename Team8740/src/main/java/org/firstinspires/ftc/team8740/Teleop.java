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
   //slowmode
    boolean slowMode = false;
    boolean buttonApressed = false;

    @Override
    public void runOpMode() throws InterruptedException {

       robot.init(hardwareMap);
       waitForStart();
       while(opModeIsActive()) {
           if(gamepad1.a && buttonApressed == false){
               slowMode= !slowMode;
               buttonApressed = true;
           }
           else if (gamepad1.a){
           }
           else{
               buttonApressed = false;
           }
           if(slowMode){
               robot.setPower(gamepad1.left_stick_y *0.3,gamepad1.right_stick_y *0.3);
           }
           else{ robot.setPower(gamepad1.left_stick_y *1, gamepad1.right_stick_y *1);}
           //foundation 1
           if(gamepad1.left_trigger > 0.5){
               robot.setIntake(gamepad1.left_trigger, -gamepad1.left_trigger);
           }
           //foundation 2
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
