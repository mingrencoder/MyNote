package base;
/*
 * 建造者模式：四个主要角色
 * Director
 * Builder
 * ConcreteBuilder
 * Product
 */
import java.util.ArrayList;
import java.util.List;

public class BuilderModel {

	public static void main(String[] args) {
		Director d = new Director();
		ConcreteBuilder1 b1 = new ConcreteBuilder1();
		ConcreteBuilder2 b2 = new ConcreteBuilder2();

		d.construct(b1);
		d.construct(b2);
		
		Product p1 = b1.getProduct();
		p1.show();
		
		Product p2 = b2.getProduct();
		p2.show();
	}

}

class Product{
	private List<String> parts = new ArrayList<String>();
	public void add(String s){
		parts.add(s);
	}
	public void show(){
		for(String s: parts){
			System.out.println(s);
		}
	}
}

interface Bulider{
	public void BulidPartA();
	public void BulidPartB();
	public Product getProduct();
}

class ConcreteBuilder1 implements Bulider{
	private Product p = new Product();
	@Override
	public void BulidPartA() {
		p.add("建造者1的部件A");
	}

	@Override
	public void BulidPartB() {
		p.add("建造者1的部件B");
	}

	@Override
	public Product getProduct() {
		return p;
	}
}

class ConcreteBuilder2 implements Bulider{
	private Product p = new Product();
	@Override
	public void BulidPartA() {
		p.add("建造者2的部件A");
	}

	@Override
	public void BulidPartB() {
		p.add("建造者2的部件B");
	}

	@Override
	public Product getProduct() {
		return p;
	}
}

class Director{
	public void construct(Bulider bulider){
		bulider.BulidPartA();
		bulider.BulidPartB();
	}
}
