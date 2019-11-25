package com.ssafy.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class Order implements Serializable {

  /* Private Fields */

  private int orderId;
  private String id; //userId
  private Date orderDate;
  private String shipAddress1;
  private String shipAddress2;
  private String shipCity;
  private String shipState;
  private String shipZip;
  private String shipCountry;
  private String billAddress1;
  private String billAddress2;
  private String billCity;
  private String billState;
  private String billZip;
  private String billCountry;
  private String  courier;
  private double totalPrice;
  private String billToFirstName;
  private String billToLastName;
  private String shipToFirstName;
  private String shipToLastName;
  private String creditCard;
  private String expiryDate;
  private String cardType;
  private String locale;
  private String status;
  private List<Cart> lineItems = new ArrayList<Cart>();

  
//  /* Public Methods */
//
//  public void initOrder(User account, Cart cart) {
//    username = account.getUsername();
//    orderDate = new Date();
//
//    shipToFirstName = account.getFirstName();
//    shipToLastName = account.getLastName();
//    shipAddress1 = account.getAddress1();
//    shipAddress2 = account.getAddress2();
//    shipCity = account.getCity();
//    shipState = account.getState();
//    shipZip = account.getZip();
//    shipCountry = account.getCountry();
//
//    billToFirstName = account.getFirstName();
//    billToLastName = account.getLastName();
//    billAddress1 = account.getAddress1();
//    billAddress2 = account.getAddress2();
//    billCity = account.getCity();
//    billState = account.getState();
//    billZip = account.getZip();
//    billCountry = account.getCountry();
//
//    totalPrice = cart.getSubTotal();
//
//    creditCard = "999 9999 9999 9999";
//    expiryDate = "12/03";
//    cardType = "Visa";
//    courier = "UPS";
//    locale = "CA";
//    status = "P";
//
//    Iterator<CartItem> i = cart.getAllCartItems();
//    while (i.hasNext()) {
//      CartItem cartItem = (CartItem) i.next();
//      addLineItem(cartItem);
//    }
//  }
//
//  public void addLineItem(CartItem cartItem) {
//    LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
//    addLineItem(lineItem);
//  }
//
//  public void addLineItem(LineItem lineItem) {
//    lineItems.add(lineItem);
//  }
}