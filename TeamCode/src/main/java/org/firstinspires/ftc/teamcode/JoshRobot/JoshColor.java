package org.firstinspires.ftc.teamcode.JoshRobot;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by robot on 1/22/2017.
 */
@Autonomous (name = "JoshColor", group = "robot")

public class JoshColor extends LinearOpMode {
    JoshRobot robot = new JoshRobot();
    ColorSensor color_sensor; // Hardware Device Object
    ColorSensor white_sensor;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F,0F,0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(com.qualcomm.ftcrobotcontroller.R.id.RelativeLayout);

        // bPrevState and bCurrState represent the previous and current state of the button.
        boolean bPrevState = false;
        boolean bCurrState = false;

        // bLedOn represents the state of the LED.
        boolean bLedOn = true;

        // get a reference to our ColorSensor object.
        color_sensor = hardwareMap.colorSensor.get("sensor_color");
        white_sensor = hardwareMap.colorSensor.get("sensor_white");
        // Set the LED in the beginning
        white_sensor.enableLed(false);

        // wait for the start button to be pressed.
        waitForStart();

        // while the op mode is active, loop and read the RGB data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {

            // check the status of the x button on either gamepad.


            // check for button state transitions.
            if ((bCurrState == true) && (bCurrState != bPrevState))  {

                // button is transitioning to a pressed state. So Toggle LED
                bLedOn = !bLedOn;
                white_sensor.enableLed(false);
            }

            // update previous state variable.
            bPrevState = bCurrState;

            // convert the RGB values to HSV values.
            Color.RGBToHSV(color_sensor.red() * 8, color_sensor.green() * 8, color_sensor.blue() * 8, hsvValues);

            // send the info back to driver station using telemetry function.
            telemetry.addData("LED", bLedOn ? "On" : "Off");
            telemetry.addData("2 Clear", white_sensor.alpha());
            telemetry.addData("3 Red  ", color_sensor.red());
            telemetry.addData("4 Green", color_sensor.green());
            telemetry.addData("5 Blue ", color_sensor.blue());
            telemetry.addData("6 Hue", hsvValues[0]);
            //telemetry.addData ("7 Touch", Touch.isPressed());
            /*if (color_sensor.red() >= color_sensor.green()) {
                robot.rightMotor.setPower(1);
            }
            else {
                robot.rightMotor.setPower(0);
            }
            if (color_sensor.green() >= color_sensor.red()) {
                robot.leftMotor.setPower(1);
            }
            else {
                robot.leftMotor.setPower(0);
            }*/
            white_sensor.enableLed(true);
            if (white_sensor.alpha() >= 200) {
                robot.rightMotor.setPower(1);
            }
            else {
                robot.rightMotor.setPower(0);
            }
            relativeLayout.post(new Runnable() {
                public void run() {
                    relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
                }
            });

            telemetry.update();
        }
    }
}


