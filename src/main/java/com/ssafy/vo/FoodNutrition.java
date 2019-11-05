package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodNutrition {
	String name;
	double supportrepeat;
	double calory;
	double carbo;
	double protein;
	double fat;
	double sugar;
	double natrium;
	double chole;
	double fattyacid;
	double transfat;
}
