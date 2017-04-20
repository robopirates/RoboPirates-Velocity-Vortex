package org.firstinspires.ftc.teamcode.Gage.Gage;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

class gagestestrobot
{
    OpticalDistanceSensor Gageoptic;
    GyroSensor GageGyro ;
    ColorSensor GageColor ;

    DcMotor  RightUp  = null;
    DcMotor  LeftUp   = null;
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();


    gagestestrobot(){

    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        Gageoptic = hwMap.opticalDistanceSensor.get("Gageoptic");
        RightUp  = hwMap.dcMotor.get("RightUp");
        LeftUp = hwMap.dcMotor.get("LeftUp");
        GageGyro = hwMap.gyroSensor.get("GageGyro");
        GageColor = hwMap.colorSensor.get("GageColor");

        RightUp.setDirection(DcMotor.Direction.REVERSE);
        LeftUp.setDirection(DcMotor.Direction.FORWARD);

        RightUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        LeftUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        RightUp.setPower(0);
        LeftUp.setPower(0);

    }



}