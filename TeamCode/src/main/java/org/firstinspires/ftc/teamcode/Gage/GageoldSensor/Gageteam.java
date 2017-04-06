//imports the package that contains methods and such
package org.firstinspires.ftc.teamcode.Gage.GageoldSensor;
//imports methods and hardware used within teleop

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//Created by dream team memes on 10/17/2016.

@TeleOp(name = "Gageteam", group = "Robot")

 class Gageteam extends OpMode {
    gagesrobot robot = new gagesrobot();

    //This is for when you have something start when you press init
    @Override
    public void init() {

        //This initializes the hardware varibles
        robot.init(hardwareMap);
        //this sets the servos position when you press "init"
        robot.Armleft.setPosition(.1);
        robot.Armright.setPosition(.1);
        robot.Clamp.setPosition(.7);
        robot.Stopper.setPosition(0);
    }

    //This is for a constant loop that happens when you press init
    @Override
    public void init_loop() {
    }

    //This is for when you have something happen when you press start
    @Override
    public void start() {
    }

    //This is for a constant loop when you press start
    @Override
    public void loop() {

        //double variables, use these in methods that use (double)
        double Left;
        double Right;
        double Slide;

        //controlling motors with buttons
       /* if (gamepad2.a)
        {robot.ConstantLeft.setPower(.95);}
        else if (gamepad2.b)
        {robot.ConstantLeft.setPower(0.0); }

        if (gamepad2.a)
        {robot.ConstantRight.setPower(.95);}
        else  if (gamepad2.b)
        {robot.ConstantRight.setPower(0.0); }*/

    /*******************************arm servos********************/
        if (gamepad2.x) {
            robot.Armleft.setPosition(1);


            robot.Armright.setPosition(1);
        }
        else if (gamepad2.y) {
            robot.Armright.setPosition(.8);
            robot.Armleft.setPosition(.8);
        }

        else {
            robot.Armleft.setPosition(.1);
            robot.Armright.setPosition(.1);
        }

        /*************************bottom stomper thing******************/
        if (gamepad2.a) {
            robot.Stopper.setPosition(0 );

        }
        else {
            robot.Stopper.setPosition(0);

        }

        /***********************clamp*************************/
        if (gamepad2.b) {
            robot.Clamp.setPosition(0 );

        }
        else {
            robot.Clamp.setPosition(.7);

        }
        //******************************//


        //defining double variables
        Left = -gamepad1.left_stick_x + gamepad1.left_stick_y;
        Right = -gamepad1.right_stick_x + gamepad1.right_stick_y;
        Slide = -gamepad2.left_stick_x + gamepad2.left_stick_y;

        //setting power to motors using double variables
        robot.LeftUp.setPower(Left);
        robot.RightUp.setPower(Right);
        robot.LSlide.setPower(Slide);
    }

    //This is for a program to run after to stop
    @Override
    public void stop() {
        telemetry.addData("good job", robot.hwMap);
    }


}