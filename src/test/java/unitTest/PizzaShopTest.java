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
		
		PizzaMenu.addPizzaToMenu("Margherita", new Pizza("Margherita",150,"medium",new Topping[]{new Topping("Tomato",10)},new Crust("Pan Pizza",0)));
		//PizzaMenu.addPizzaToMenu("Hawaiian Delight- Veg", new Pizza("Margherita",150,"medium",new Topping("Tomato",10),new Crust("Pan Pizza",0)));

	}

	
	
	@Test
	public void retrieveToppingName() {
		assertEquals("Tomato",PizzaMenu.getToppingFromMenu("Tomato").getName());
		

	}
	
	@Test
	public void retrievePizzaName() {
		assertEquals("Margherita",PizzaMenu.getPizzaFromMenu("Margherita").getName());

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
	public void retrievePizzaPrice() {
		assertEquals("150.0",Double.toString(PizzaMenu.getPizzaFromMenu("Margherita").getPrice()));
		

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
		Item crust1 = (Item) PizzaMenu.getCrustFromMenu("Thin Crust");
		
		PizzaShop shop = new PizzaShop();
		
		shop.addCurrentToOrderList(new Item[]{pizza1,topping1,crust1});
		
		
		System.out.println(Order.getOrderList().get(0)[0].getName());
		
	}
	
	
	
	
	
	
	
	

}
