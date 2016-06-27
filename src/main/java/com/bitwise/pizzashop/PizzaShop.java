package com.bitwise.pizzashop;

import java.util.ArrayList;

public class PizzaShop {


	private static final Exception IllegalArgumentException = null;
	double totalCost = 0.0;
	int numberOfPizzas=0;
	int perOrder =0;
	private double vatCollected;
	private double serviceTaxCollected;
	
	

	//pizza name topping crust
	public void addCurrentToOrderList(Item[] thisOrder){
		new Order (thisOrder);
		
	}
	
	


	public double calculate(String pizza, String toping, String crust) {
		return 0;
    }




	public double calculate(ArrayList<Item[]> orderList) {
		// TODO Auto-generated method stub
		numberOfPizzas=orderList.size();
		
		System.out.println("Pizza shop " + numberOfPizzas);
		//System.out.println("Pizza shop" + orderList.size());

	//System.out.println("Pizza shop" + Order.getOrderList().get(1)[0].getItemPrice());
		
		for(int i = 0 ; i < numberOfPizzas ; i++){
			int perOrder =  Order.getOrderList().get(i).length;
			
		//	  validate(perOrder);
			
			System.out.println("Pizza shop " + perOrder);
			
			for(int j = 0 ; j < perOrder ; j++){
				
			//	if("small".equals(Order.getOrderList().get(i)[j].getSize()))
				totalCost = totalCost + Order.getOrderList().get(i)[j].getItemPrice();
				
				System.out.println("Pizza shop " + totalCost);
			}
			
		}
		
		System.out.println("Pizza shop 2 " + totalCost);

		
		vatCollected =  totalCost*TaxConstants.VAT/100;
		serviceTaxCollected= (totalCost + vatCollected)*TaxConstants.SERVICE_TAX/100;
		
		System.out.println("Pizza shop with VAT  " + vatCollected);
		System.out.println("Pizza shop with Service Tax   " +serviceTaxCollected);
		
		return totalCost + vatCollected + serviceTaxCollected;
	}




	private void validate(int perOrder) throws Exception {
		// TODO Auto-generated method stub
		this.perOrder= perOrder;
		if(perOrder <2)
              throw IllegalArgumentException;
		
		
	}
	



}