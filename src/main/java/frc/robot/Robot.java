package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Go out";
  private static final String kCustomAuto = "score";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private DifferentialDrive URCHIN;

  double StartTime;
  double periodicTime;

  //drive----------------
  SparkMax M_L1;
  SparkMax M_R1;
  SparkMax M_L2;
  SparkMax M_R2;
  SparkMax M_RL;
  SparkMax M_CL;
  //----------------------

  //ID---------------------
  int L1Id = 1;
  int R1Id = 2;
  int L2Id = 3;
  int R2Id = 4;
  int RLId = 5;
  int CLId = 6;
 //----------------------

 //current limit------------
  int CurrentLimit = 50;
  int CurrentLimit2 = 25;
 //------------------------

  private XboxController driveController = new XboxController(0);
  private XboxController opController1 = new XboxController(1);
  private XboxController opController2 = new XboxController(2);

  SparkBaseConfig config = new SparkBaseConfig();
   
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    //motor type---------------------
    M_L1 = new SparkMax(L1Id, MotorType.kBrushless);
    M_R1 = new SparkMax(R1Id, MotorType.kBrushless);
    M_L2 = new SparkMax(L2Id, MotorType.kBrushless);
    M_R2 = new SparkMax(R2Id, MotorType.kBrushless);
    M_RL = new SparkMax(RLId, MotorType.kBrushless);
    M_CL = new SparkMax(CLId, MotorType.kBrushless);
    //---------------------------------------------------------

    M_L1.setInverted(false);
    M_R1.setInverted(true);
    
    M_L2.isFollower();
    M_R2.isFollower();

    


  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  
  @Override
  public void teleopInit() {}

  
  @Override
  public void teleopPeriodic() {
    URCHIN.tankDrive(-driveController.getLeftY(), -driveController.getRightY());

    if (opController1.getAButton()) { M_RL.set(1);
    }
  }

  
  @Override
  public void disabledInit() {}

  
  @Override
  public void disabledPeriodic() {}

  
  @Override
  public void testInit() {}

  
  @Override
  public void testPeriodic() {}

  
}
