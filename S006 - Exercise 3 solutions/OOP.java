
class A {
	public String method1() {
		return "A1";
	}

	public String method2() {
		return "A2";
	}
}

class B extends A {
	@Override
	public String method2() {
		return this.method1() + "B2";
	}
}

class C extends B {
	@Override
	public String method1() {
		return "C1";
	}
}

class D extends C {
	@Override
	public String method1() {
		return "D1";
	}
}

public class OOP {
	public static void main(String[] args) {
		A[] elements = { new D(), new A(), new C(), new B() };
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i].method1());
			System.out.println(elements[i].method2());
			System.out.println();
		}
	}
}
