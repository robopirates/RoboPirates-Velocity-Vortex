package org.firstinspires.ftc.teamcode.Gage.GageoldSensor;

//imports hardware used within your hardware
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Const;

/*
 * This is NOT an opmode.
 * This class can be used to define all the specific hardware for a single robot.
 */
 class gagesrobot
{

    /* Public OpMode members. */
    //null tells hardware to not cache data
    DcMotor  RightUp  = null;
     DcMotor  LeftUp   = null;
     //DcMotor  ConstantLeft = null;
    // DcMotor  ConstantRight = null
     DcMotor LSlide =null;

     Servo Armleft = null;
     Servo Armright = null;
    Servo Clamp =null;
    Servo Stopper = null;

    /* local OpMode members. */
     HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();


     gagesrobot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        // Define and Initialize Motors
        RightUp  = hwMap.dcMotor.get("RightUp");
        LeftUp = hwMap.dcMotor.get("LeftUp");
       // ConstantLeft = hwMap.dcMotor.get("ConstantLeft");
        //ConstantRight= hwMap.dcMotor.get("ConstantRight");
        LSlide  = hwMap.dcMotor.get("LSlide");
        Armright = hwMap.servo.get("Armright");
        Armleft = hwMap.servo.get("Armleft");
        Clamp = hwMap.servo.get("Clamp");
        Stopper = hwMap.servo.get("Stopper");


        // Set to REVERSE if using AndyMark motors
        // Set to FORWARD if using AndyMark motors(optional)

        RightUp.setDirection(DcMotor.Direction.REVERSE);
        LeftUp.setDirection(DcMotor.Direction.FORWARD);
        //ConstantLeft.setDirection(DcMotor.Direction.FORWARD);
       // ConstantRight.setDirection(DcMotor.Direction.REVERSE);
        LSlide.setDirection(DcMotor.Direction.FORWARD);

        Armright.setDirection(Servo.Direction.FORWARD);
        Armleft.setDirection(Servo.Direction.REVERSE);



        /*setting a zero power behavior to float allows it to coast down to desired motor power
        setting it to brake causes it to brake instantly to desired motor power*/

        RightUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
       LeftUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        //desired power of motors when no commands are given
        RightUp.setPower(0);
        LeftUp.setPower(0);
       // ConstantLeft.setPower(0);
       // ConstantRight.setPower(0);
        LSlide.setPower(0);

    }



}