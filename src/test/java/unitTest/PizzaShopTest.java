package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bitwise.pizzashop.Crust;
import com.bitwise.pizzashop.Item;
import com.bitwise.pizzashop.Order;
import com.bitwise.pizzashop.Pizza;
import com.bitwise.pizzashop.PizzaMenu;
import com.bitwise.pizzashop.PizzaShop;
import com.bitwise.pizzashop.Size;
import com.bitwise.pizzashop.Topping;

public class PizzaShopTest {
	
	@Before
	public void beforeEachTest() {
		
		
		PizzaMenu.addToppingToMenu("Tomato",new Topping("Tomato",10));
		PizzaMenu.addToppingToMenu("Pineapple",new Topping("Pineapple",20));
		
		PizzaMenu.addCrustToMenu("Pan Pizza", new Crust("Pan Pizza",100));
		PizzaMenu.addCrustToMenu("Regular", new Crust("Pan Pizza",0));
		PizzaMenu.addCrustToMenu("Thin Crust", new Crust("Thin Crust",150));
		PizzaMenu.addCrustToMenu("Cheese Burst", new Crust("Cheese Burst",200));
		
		PizzaMenu.addPizzaToMenu("Margherita", new Pizza("Margherita",new Topping[]{new Topping("Tomato",10)},new Crust("Regular",0)));

		
		PizzaMenu.addPizzaSizePriceToMenu("small", new Size("Margherita",80,"small"));
		PizzaMenu.addPizzaSizePriceToMenu("medium", new Size("Margherita",150,"medium"));
		PizzaMenu.addPizzaSizePriceToMenu("large", new Size("Margherita",300,"large"));


		//PizzaMenu.addPizzaToMenu("Hawaiian Delight- Veg", new Pizza("Margherita",150,"medium",new Topping("Tomato",10),new Crust("Pan Pizza",0)));

	}

	
	
	@Test
	public void retrieveToppingName() {
		assertEquals("Tomato",PizzaMenu.getToppingFromMenu("Tomato").getName());
		

	}
	
	@Test
	public void retrievePizzaName() {
		
		System.out.println("Chk " + PizzaMenu.getPizzaFromMenu("Margherita").getName());
		assertEquals("Margherita",PizzaMenu.getPizzaSizePriceToMenu("Margherita").getName());

	}
	
	@Test
	public void retrieveCrustName() {
		assertEquals("Pan Pizza",PizzaMenu.getCrustFromMenu("Pan Pizza").getName());

	}
	
	@Test
	public void retrieveToppingPrice() {
		assertEquals("10.0",Double.toString(PizzaMenu.getToppingFromMenu("Tomato").getItemPrice()));
		

	}

	@Test
	public void retrieveCrustPrice() {
		assertEquals("150.0",Double.toString(PizzaMenu.getCrustFromMenu("Thin Crust").getItemPrice()));
		

	}
	
	@Test(expected=NullPointerException.class)
	public void placeOrderShouldThrowNullPointerIfOrderNull() {
		//assertEquals("150.0",Double.toString(PizzaMenu.getCrustFromMenu("Thin Crust").getCrustPrice()));
		
		Order order = new Order(null);

	}
	
	@Test
	public void placeAnOrder_ShouldGoSmooth(){
		Item pizza1 = (Item) PizzaMenu.getPizzaFromMenu("Margherita");
		Item topping1 = (Item) PizzaMenu.getToppingFromMenu("Tomato");
		Item topping3 = (Item) PizzaMenu.getToppingFromMenu("Pineapple");
		Item crust1 = (Item) PizzaMenu.getCrustFromMenu("Thin Crust");
		
		Item pizza2 = (Item) PizzaMenu.getPizzaFromMenu("Margherita");
		Item topping2 = (Item) PizzaMenu.getToppingFromMenu("Tomato");
		Item crust2 = (Item) PizzaMenu.getCrustFromMenu("Thin Crust");
		
		Item pizza3= (Item) PizzaMenu.getPizzaFromMenu("Margherita");
		Item size= (Item) PizzaMenu.getPizzaSizePriceToMenu("small");
		
		PizzaShop shop = new PizzaShop();
		
		//shop.addCurrentToOrderList(new Item[]{pizza1,topping1,topping3,crust1});
		//shop.addCurrentToOrderList(new Item[]{pizza2,topping2,crust2});
		
		shop.addCurrentToOrderList(new Item[]{pizza3,size});
		
		
		System.out.println(Order.getOrderList().get(0).length);
		//System.out.println(Order.getOrderList().get(1).length);
	//	System.out.println(Order.getOrderList().get(1)[0].getItemPrice());
		System.out.println(Order.getOrderList().get(0)[1].getName());
		//System.out.println(Order.getOrderList().get(0)[4].getName());
		
		//System.out.println(Order.getOrderList().size());
		
		//System.out.println(Order.getOrderList().get(2)[1].getPrice());
		
		//Order.getOrderList().get(2)[1].getSize();
		
		
		//System.out.println(Order.getOrderList().);
		
		double price = shop.calculate(Order.getOrderList());
		
		System.out.println(price);
		
		assertEquals("101.2",Double.toString(price));

		
		
	}
	
	
/*	@Test
	public void retrievePizzaSize() {
		
		System.out.println(PizzaMenu.getPizzaFromMenu("small").getName());
	//	assertEquals("small",PizzaMenu.getToppingFromMenu("Tomato").getSize());
		
	
	}*/
	
	
	

}
