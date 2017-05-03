//This is a Program!!!!!
/*This program is to show new recruits the ins and out
of basic programming without it being so scary
 */



//This is a package and is what this java class is contained in
package org.firstinspires.ftc.teamcode.Other;

//These are import packages that help the program understand certain codes like autonomous and TeleOp
// they import methods that can be used later in the "active" portion of the program
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//This bit of code below is how the android phones find the name of the java class and can be seperated by Autonomous or TeleOp
//@Disabled disables the java class from showing up on the phone
/*@Autonomous or */ @TeleOp
        (name = "JoshAuto", group = "Robot")//The name is what will show up on the phone
@Disabled

//This is a java class/file to write code, it is like a notepad but on your computer! Keep all actions in the program in this class!!!
public class ShowProgram extends OpMode /*OpMode or LinearOpMode*/ {

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap) {
//********************initialization******************************\\

        //this is where hardware variables will be recognized and where the initialization of your robot begins


        hwMap = ahwMap;
        DcMotor Motor = null;                   // null tells the system not to cache data
        Servo Servo = null;
        Motor = hwMap.dcMotor.get("Motor");     //The text in green is what goes in your configuration file
        Servo = hwMap.servo.get("Servo");
        Motor.setDirection(DcMotor.Direction.REVERSE);  //Motors can be set FORWARD or REVERSE.

        Motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT/*(BRAKE)*/);//setting a zero power behavior to float allows it to coast

    }
    //This is for when you have something start when you press init
    @Override // 'override" states that the current class takes priority over previous classes and the parent class
    public void init() {
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
    }
    }