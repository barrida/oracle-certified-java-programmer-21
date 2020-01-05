package functional.interfacee;

public class Main {

	public static void main(String[] args) {

		BodyMassIndex bmiUsingLambda = (double weight, double height) -> weight / (height * height);
		BodyMassIndex bmiFemale = new BodyMassFemale();
		BodyMassIndex bmiMale = new BodyMassMale();
			
		System.out.println("The Body Mass Index (BMI) for female is " + bmiFemale.calculate(70, 1.7) + " kg/m2");
		System.out.println("The Body Mass Index (BMI) for male is " + bmiMale.calculate(70, 1.7) + " kg/m2");
		System.out.println("The Body Mass Index (BMI) for male using lambda is " + bmiUsingLambda.calculate(70, 1.7) + " kg/m2");
		
	
	}

}
