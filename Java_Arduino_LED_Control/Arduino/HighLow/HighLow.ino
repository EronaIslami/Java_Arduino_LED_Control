int ledPin = 7; 

void setup() {
  pinMode(ledPin, OUTPUT); 
  Serial.begin(9600);      
}

void loop() {
  if (Serial.available() > 0) { 
    char receivedChar = Serial.read(); 
    if (receivedChar == 'H') {
      digitalWrite(ledPin, HIGH); 
    }
    else if (receivedChar == 'L') {
      digitalWrite(ledPin, LOW); 
    }
  }
}
