package com.sky.assignments.shoppingcart.model;

import java.math.BigDecimal;

public interface Promotion {

	BigDecimal charge(Product item, int count);

	boolean appliesTo(Product item);
}
