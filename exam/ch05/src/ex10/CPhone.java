package ex10;

public class CPhone implements IFunction {

	@Override
	public void callSenderReceive() {
		System.out.println("가능 합니다.");
	}

	@Override
	public void canLte() {
		System.out.println("가능 합니다. 5G입니다.");
	}

	@Override
	public void tvRemoteController() {
		System.out.println("미탑재 되어 있습니다.");
	}

}
