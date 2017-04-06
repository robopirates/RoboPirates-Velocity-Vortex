package org.firstinspires.ftc.teamcode.joshauto;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.JoshRobot.JoshRobot;

/**
 * Created by robot on 1/24/2017.
 */
@Autonomous (name= "JoshBallandTurnBS", group= "Robot")
@Disabled
public class JoshBallandTurnBS extends LinearOpMode {
    JoshRobot robot = new JoshRobot();
    ColorSensor color_sensor;
    ColorSensor white_sensor;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.rightMotor.setDirection(DcMotor.Direction.REVERSE);

        float hsvValues[] = {0F,0F,0F};

        final float values[] = hsvValues;

        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(com.qualcomm.ftcrobotcontroller.R.id.RelativeLayout);



        boolean bPrevState = false;
        boolean bCurrState = false;

        color_sensor = hardwareMap.colorSensor.get("sensor_color");
        white_sensor = hardwareMap.colorSensor.get("sensor_white");
        color_sensor.enableLed(false);

        waitForStart();


        while (opModeIsActive()) {


            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(1);
            sleep(1000);
            robot.leftMotor.setPower(-1);
            robot.rightMotor.setPower(1);
            sleep(1000);
            robot.armMotor.setPower(-1);
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0);
            sleep(500);
            robot.armMotor.setPower(1);
            sleep(800);
            robot.armMotor.setPower(0);
            sleep(500);
            robot.armMotor.setPower(-1);
            sleep(800);
            robot.armMotor.setPower(0);
            robot.leftMotor.setPower(-1);
            robot.rightMotor.setPower(1);
            sleep(1400);
            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(1);
            sleep(2250);
            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(-1);
            sleep(1600);
            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(1);
            sleep(600);
            robot.leftMotor.setPower(-1);
            robot.rightMotor.setPower(1);
            sleep(2000);
            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(1);
            sleep(1000);
            /*if (white_sensor.alpha() >= 200) {
                robot.leftMotor.setPower(1);
                robot.rightMotor.setPower(1);
            }
            else {
                robot.rightMotor.setPower(1);
                robot.leftMotor.setPower(0);
            }*/
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0);
            robot.colorMotor.setPower(-1);
            sleep(1250);
            robot.colorMotor.setPower(1);
            sleep(500);
            robot.colorMotor.setPower(0);
            sleep(4000);
            if (color_sensor.red() >= color_sensor.green()) {

                robot.colorMotor.setPower(-1);
                sleep(1250);
                robot.colorMotor.setPower(1);
                sleep(1250);
            }
            else {
                robot.colorMotor.setPower(0);
            }
            if (color_sensor.green() >= color_sensor.red()) {
                robot.colorMotor.setPower(0);
                sleep(1250);
                robot.colorMotor.setPower(0);
                sleep(1250);
            }
            else {
                robot.colorMotor.setPower(0);
            }
            sleep(3000);
            robot.rightMotor.setPower(-1);
            robot.leftMotor.setPower(-1);
            sleep(4000);
            /*robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(-1);
            sleep(1700);
            robot.leftMotor.setPower(1);
            robot.rightMotor.setPower(1);
            sleep(2000);*/
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0);
            robot.armMotor.setPower(0);
            sleep(30000);

            if ((bCurrState == true) && (bCurrState != bPrevState))  {

                // button is transitioning to a pressed state. So Toggle LED
                //bLedOn = !bLedOn;
                color_sensor.enableLed(false);
            }

            bPrevState = bCurrState;

            Color.RGBToHSV(color_sensor.red() * 8, color_sensor.green() * 8, color_sensor.blue() * 8, hsvValues);

            telemetry.addData("2 Clear", color_sensor.alpha());
            telemetry.addData("3 Red  ", color_sensor.red());
            telemetry.addData("4 Green", color_sensor.green());
            telemetry.addData("5 Blue ", color_sensor.blue());
            telemetry.addData("6 Hue", hsvValues[0]);


            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}
