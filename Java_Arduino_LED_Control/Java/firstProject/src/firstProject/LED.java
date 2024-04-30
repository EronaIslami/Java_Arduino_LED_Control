package firstProject;
import java.io.IOException;
import java.util.Scanner;
import com.fazecast.jSerialComm.SerialPort;
import java.jSerialComm.Port;

public class LED {

	 public static void main(String[] args) {
	        SerialPort serialPort = SerialPort.getCommPort("COM3");
	        serialPort.setComPortParameters(9600, 8, 1, 0);
	        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

	        if (!serialPort.openPort()) {
	            System.out.println("Failed to open the serial port.");
	            return;
	        }

	        Scanner scanner = new Scanner(System.in);
	        
	        while(true) {
	        try {
	            System.out.print("H or L : ");
	            char inputChar = scanner.next().charAt(0);

	            // Convert the character to a byte
	            byte charByte = (byte) inputChar;

	            // Send the byte to the serial port
	            serialPort.getOutputStream().write(charByte);

	            //System.out.println("Character sent to serial port: " + inputChar);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       }	      
	    }
	}